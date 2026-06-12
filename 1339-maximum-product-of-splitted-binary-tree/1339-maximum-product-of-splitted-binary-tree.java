class Solution {
    final int MOD = 1_00_000_000_7 ;
    private long maxProduct = 1L;
    
    public int maxProduct(TreeNode root) {
        
        int totalSum = traverse(root);
        findMaxProduct(root,totalSum);
        return (int)(maxProduct%MOD);

    }

    private int findMaxProduct(TreeNode root,int totalSum){
        if (root == null) return 0;

        int leftSum = findMaxProduct(root.left,totalSum);
        long currentProduct = (leftSum)*((long)(totalSum - leftSum));
        this.maxProduct = Math.max(currentProduct , maxProduct);
        
        int rightSum = findMaxProduct(root.right,totalSum);
        currentProduct = (rightSum)*((long)(totalSum - rightSum));
        this.maxProduct = Math.max(currentProduct , maxProduct);

        return leftSum + rightSum + root.val;
    }

    private int traverse(TreeNode root){

        if (root == null){
            return 0;
        }
        int leftSum = traverse(root.left);
        int rightSum = traverse(root.right);
        return leftSum + rightSum + root.val;
    }
}