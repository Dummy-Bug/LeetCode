class Solution:
    def findSum(self,A,N): 
        if N == 1:
            return 2*A[0];
        if N == 2:
            return sum(A);
        if N&1 == 0:
            minValue = min(A[0],A[1]);
            maxValue = max(A[0],A[1]);
            i = 2;
        else:
            minValue = A[0];
            maxValue = A[0];
            i = 1;

        while i < N-1:
            
            if A[i] < A[i+1]:
                minValue = min(minValue,A[i]);
                maxValue = max(maxValue,A[i+1]);
            else:
                minValue = min(minValue,A[i+1]);
                maxValue = max(maxValue,A[i]);
            # print(minValue,maxValue,i)
            i += 2;
        return minValue+maxValue;



#{ 
 # Driver Code Starts
#Initial Template for Python 3



t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    ob = Solution()
    print(ob.findSum(a,n))
# } Driver Code Ends