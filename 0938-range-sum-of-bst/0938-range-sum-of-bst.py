class Solution:
    def rangeSumBST(self, A: Optional[TreeNode], B: int, C: int) -> int:
        self.Count = 0;

        self.NodesInRange(A,B,C);
        return self.Count;
    
    def NodesInRange(self,node,left_limit,right_limit):

        if not node:
            return;
        
        if left_limit<=node.val and right_limit>=node.val:
            self.Count += node.val;
        
        if node.val > left_limit:
            self.NodesInRange(node.left,left_limit,right_limit);
        
        if node.val < right_limit:
            self.NodesInRange(node.right,left_limit,right_limit);
        