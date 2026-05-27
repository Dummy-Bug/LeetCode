class Solution {
    
    Map<Integer,Integer> map;

    private TreeNode helper(int start, int end, int inStart, int[] pre , int[] in){
        
        if (start > end || start >= pre.length){
            return null;
        }
        
        int pos = map.get(pre[start]);
        int length = pos - inStart;
        
        TreeNode node = new TreeNode(pre[start]);
        
        node.left = helper(start + 1 , start + length , inStart , pre , in);
        node.right = helper(start + length + 1, end ,pos + 1, pre , in);

        return node;
    }

    public TreeNode bstFromPreorder(int[] preOrder) {
        

        int n = preOrder.length;
        int [] inOrder = new int[n];
        
        for (int i = 0; i < n; i++){
            inOrder[i] = preOrder[i];
        }
        Arrays.sort(inOrder);

        map = new HashMap<>();

        for (int i = 0; i < n; i++){
            map.put(inOrder[i],i);
        }

        return helper(0,n-1,0,preOrder,inOrder);

    }
}