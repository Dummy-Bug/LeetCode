# User function Template for python3

class Solution:

	def equilibriumPoint(self,A,n): 
        

        left_sum  = 0;
        right_sum = 0;

        for i in range(len(A)):
            right_sum += A[i];
        
        for i in range(len(A)):

            left_sum += A[i];
            # now ith elelment is both in left and right sum 
            if left_sum == right_sum:
                return i+1;
                
            right_sum  -= A[i];

        return -1;


#{ 
 # Driver Code Starts
# Initial Template for Python 3

import math


def main():

    T = int(input())

    while(T > 0):

        N = int(input())

        A = [int(x) for x in input().strip().split()]
        ob=Solution()

        print(ob.equilibriumPoint(A, N))

        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends