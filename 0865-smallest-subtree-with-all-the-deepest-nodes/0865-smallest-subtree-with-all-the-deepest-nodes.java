class Solution {

    private int maxDepth = 0;
    private Deque<TreeNode> maxDepthPath = new ArrayDeque<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        findDeepestPath(root,0,new ArrayDeque<>());
        
        Deque<TreeNode> orderedPath = new ArrayDeque<>();

        while(!maxDepthPath.isEmpty()){
            orderedPath.push(maxDepthPath.pop());
        }

        maxDepth--;
        while(!orderedPath.isEmpty()){

            TreeNode node = orderedPath.pop();
            int leftDepth = getMaxDepth(node.left);
            int rightDepth = getMaxDepth(node.right);
            
            if (leftDepth == rightDepth && leftDepth == maxDepth){
                return node;
            }
            maxDepth--;
        }
        return null;

    }

    private int getMaxDepth(TreeNode node){

        if (node == null){
            return 0;
        }
        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);

        return 1 + Math.max(left,right);
    }

    private void findDeepestPath(TreeNode node,int depth,Deque<TreeNode> path){

        if (node == null){
            
            if (depth > maxDepth){
                maxDepthPath = new ArrayDeque<>(path);
                maxDepth = depth;
            }
            return ;
        }

        path.push(node);
        findDeepestPath(node.left,depth + 1,path);
        findDeepestPath(node.right,depth + 1,path);
        path.pop();
    }
}