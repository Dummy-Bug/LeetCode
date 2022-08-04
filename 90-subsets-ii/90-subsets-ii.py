class Solution:
	# @param A : list of integers
	# @return a list of list of integers
	def subsetsWithDup(self, A):
		A.sort();
		
		self.all_subsets = [];
		
		self.backtrack(A,0,[]);
		
		return self.all_subsets;
	
	def backtrack(self,A,start_index,curr_subsets):
		
		
		self.all_subsets.append(list(curr_subsets));
		
		for i in range(start_index,len(A)):
			
			if i != start_index and A[i] == A[i-1]:
				continue;

			curr_subsets.append(A[i]);
			self.backtrack(A,i+1,curr_subsets);
			curr_subsets.pop();