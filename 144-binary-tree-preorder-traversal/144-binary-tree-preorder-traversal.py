
class Solution:
    def preorderTraversal(self, A: Optional[TreeNode]) -> List[int]:
        if A == None:
            return []
        preorder = [];
        stack    = [A];
        
        while stack != []:
            
            node = stack.pop();
            
            preorder.append(node.val);

            if node.right != None:
                stack.append(node.right);
                            
            if node.left != None:
                stack.append(node.left);

        
        return preorder;