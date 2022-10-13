class Solution:

	def isValidBST(self, A):
		inorder_list = []
		self.Inorder(A,inorder_list);

		for i in range(1,len(inorder_list)):
			if inorder_list[i] <= inorder_list[i-1]:
				return 0;
		return 1;
	
	def Inorder(self,node,inorder_list):
		if not node:
			return;
		
		self.Inorder(node.left,inorder_list);
		inorder_list.append(node.val);
		self.Inorder(node.right,inorder_list);
		return;

