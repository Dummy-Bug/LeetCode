class Solution:

    def kthSmallest(self, A, B):
        
        self.curr_smallest = 0;
        
        return self.helper(A,B);

    
    def helper(self,node,k):
        
        if not node :
            return 0;
        
        left = self.helper(node.left,k);
        if left:
            return left;
            
        self.curr_smallest += 1;
        if k == self.curr_smallest:
            return node.val;
            
        right = self.helper(node.right,k);
        if right:
            return right;
        
        return 0;