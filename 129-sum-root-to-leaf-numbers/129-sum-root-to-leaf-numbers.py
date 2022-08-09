class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root,'');
    
    
    def helper(self,node,curr_path):
        
        if node == None:
            return 0;
        
        if node.left == node.right == None:
            
            return int( curr_path+str(node.val) );
        
        left_sum  = self.helper(node.left,curr_path+str(node.val));
        right_sum = self.helper(node.right,curr_path+str(node.val));
        
        return (left_sum+right_sum);