class Solution {

    List<Integer> inorder = new ArrayList<>();

    private void traversal(TreeNode root){

        if (root == null){
            return;
        }
        traversal(root.left);
        inorder.add(root.val);
        traversal(root.right);
    }

    private int findCeil(int num){
        
        int low = 0;
        int high = inorder.size() - 1;
        int candidate = -1;

        while (low <= high){

            int mid = (low + high)/2;

            if (inorder.get(mid) == num){
                return inorder.get(mid);
            }
            else if (inorder.get(mid) > num){
                candidate = inorder.get(mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return candidate;
    }
    private int findFloor(int num){

        int low = 0;
        int high = inorder.size() - 1;
        int candidate = -1;

        while (low <= high){

            int mid = (low + high )/2;

            if (inorder.get(mid) == num){
                return inorder.get(mid);
            }
            else if (inorder.get(mid) < num){
                candidate = inorder.get(mid);
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return candidate;
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        
        traversal(root);

        int n = queries.size();

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            
            int q = queries.get(i);
            
            int floor = findFloor(q);
            int ceil = findCeil(q);

            List<Integer> range = new ArrayList<>();
            range.add(floor);
            range.add(ceil);

            ans.add(range); 
            
        }

        return ans;
    }
}