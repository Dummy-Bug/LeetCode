class Solution:
	def isSameTree(self, node1, node2):
		
		if node1 == None and node2 == None:
			return 1;
		
		if node1 == None or node2 == None:
			return 0;
		
		if node1.val != node2.val:
			return 0;
		
		return self.isSameTree(node1.left,node2.right) & self.isSameTree(node1.right,node2.left);
	
	def isSymmetric(self, A):
		
		if A == None:
			return 1;
		
		return self.isSameTree(A.left,A.right);
		
