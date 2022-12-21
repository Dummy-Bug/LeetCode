class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.max = -1;
        
        def dfs(node):
            if not node:
                return 0
            left , right = 0 , 0
            if node.left:
                left  = 1  + dfs(node.left)
            if node.right:
                right = 1  +  dfs(node.right)
            if left + right > self.max:
                self.max = left + right
            return max(left,right)
        dfs(root)
        return self.max
            