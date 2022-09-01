class Solution:
    
    def dfs(self,node,curr_max):
        if not node:
            return ;
        
        if node.val >= curr_max:
            self.count += 1;
            curr_max = node.val;
        
        self.dfs(node.left,curr_max);
        self.dfs(node.right,curr_max);
        
    def goodNodes(self, root: TreeNode) -> int:
        
        self.count = 0;
        
        self.dfs(root,root.val);
        return self.count;
    
        