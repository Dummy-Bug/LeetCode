class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:


        self.Hash_map = dict();

        for i in range(len(inorder)):
            self.Hash_map[inorder[i]] = i;
        
        return self.constructTree(preorder,inorder,0,len(preorder)-1,0,len(inorder)-1);
    
    def constructTree(self,preorder,inorder,Ps,Pe,Is,Ie):

        if Ps > Pe:
            return None;
        node  = TreeNode(preorder[Ps]);
        index = self.Hash_map[node.val];

        node.left  = self.constructTree(preorder,inorder,Ps+1,Ps+index-Is,Is,index-1);
        node.right = self.constructTree(preorder,inorder,Ps+index-Is+1,Pe,index+1,Ie);

        return node;

        


        
		


        