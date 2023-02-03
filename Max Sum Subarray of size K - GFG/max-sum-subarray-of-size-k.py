#User function Template for python3
class Solution:
    def maximumSumSubarray (self,k,arr,n):
        current_sum = 0
        i = 0
        
        while i < k:
            current_sum += arr[i]
            i = i + 1
        max_sum = current_sum
        current_sum = current_sum - arr[0]
        
        i = 1
        while i <= (n-k):
            
            current_sum += arr[k+i-1]
            max_sum = max(current_sum,max_sum)
            current_sum  = current_sum - arr[i]
            i = i + 1
            
        return max_sum

#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        
        N,K = input().split()
        N = int(N)
        K = int(K)
        Arr = list( map(int,input().strip().split(" ")))

        ob = Solution()
        print(ob.maximumSumSubarray(K,Arr,N))
# } Driver Code Ends