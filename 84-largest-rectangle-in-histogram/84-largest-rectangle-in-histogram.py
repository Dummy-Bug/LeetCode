
class Solution:

	def largestRectangleArea(self, A):

		nsl = []; nsr = [];
		stack = deque([]);

		for i in range(len(A)):

			while stack and A[stack[-1]] >= A[i]:
				stack.pop();
			if not stack:
				nsl.append(-1);
			else:
				nsl.append(stack[-1]);
			stack.append(i);

		stack = deque([]);

		for i in range(len(A)-1,-1,-1):

			while stack and A[stack[-1]] >= A[i]:
				stack.pop();
			if not stack:
				nsr.append(len(A));
			else:
				nsr.append(stack[-1]);
			stack.append(i);

		nsr = nsr[::-1];
		max_area = 0;

		for i in range(len(A)):

			width = nsr[i]-nsl[i]-1;
			curr_area = A[i]*width;

			max_area = max(max_area,curr_area);
		
		return max_area;




