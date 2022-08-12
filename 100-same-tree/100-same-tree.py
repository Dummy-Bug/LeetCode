class Solution:

	def isSameTree(self, node1, node2):
		
		if node1 == None and node2 == None:
			return 1;
		elif node1 == None and node2 != None:
			return 0;
		elif node2 == None and node1 != None:
			return 0;
		
		if node1.val != node2.val:
			return 0;
		
		return self.isSameTree(node1.left,node2.left) & self.isSameTree(node1.right,node2.right);
		