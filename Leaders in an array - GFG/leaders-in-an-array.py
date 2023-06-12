class Solution:
    # Function to find the leaders in the array.
    def leaders(self, A, N):

        currMax = A[-1];
        leaders = [currMax];
        for i in range(N-2,-1,-1):
            if A[i] >= currMax:
                leaders.append(A[i]);
                currMax = A[i];
        return reversed(leade;
    
    def reversed(self,leaders):
        
        for i in range(len(leaders)//2):
            leaders[i],leaders[len(leaders)-1-i] = leaders[len(leaders)-1-i],leaders[i];
            
        return leaders;


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math


    
def main():
    
    T=int(input())
    
    while(T>0):
        
        
        N=int(input())
        
        A=[int(x) for x in input().strip().split()]
        obj = Solution()
        
        A=obj.leaders(A,N)
        
        for i in A:
            print(i,end=" ")
        print()
        
        T-=1

if __name__=="__main__":
    main()
# } Driver Code Ends