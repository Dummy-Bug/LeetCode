class Solution:
    def findTarget(self, A: Optional[TreeNode], B: int) -> bool:


        self.Hash_set = set();

        return self.traversal(A,B);
    
    def traversal(self,node,target):
        if not node:
            return;
        
        if target-node.val in self.Hash_set:
            return 1;
        
        self.Hash_set.add(node.val);

        if self.traversal(node.left,target) or self.traversal(node.right,target):
            return 1;
        return 0; 

