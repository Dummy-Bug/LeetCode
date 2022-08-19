class Solution:

	def evalRPN(self, A):
		
		stack = [];

		
		for i in range(len(A)):
			char = A[i];
			
			if char == '+':
				b = int( stack.pop() );
				a = int( stack.pop() );
				
				stack.append(str(a+b));
			
			elif char == '*':
				b = int( stack.pop() );
				a = int( stack.pop() );
				
				stack.append(str(a*b));
			
			elif char == '/':
				
				b = int( stack.pop() );
				a = int( stack.pop() );
				if (a>0 and b>0) or(a<0 and b<0):
					stack.append(str(a//b));
				else:
					stack.append(str(-1* (abs(a)//abs(b))));
			
			elif char == '-':
				b = int( stack.pop() );
				a = int( stack.pop() );
				
				stack.append(str(a-b));
			
			else:
				stack.append(char);
			
			# print(stack);
		return int(stack.pop());
