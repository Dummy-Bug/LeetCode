#User function Template for python3

class Solution:
    def sumoflength(self,arr, n):
     
        # For maintaining distinct elements.
        s = []
     
        # Initialize ending point and result
        j = 0
        ans = 0
     
        # Fix starting point
        for i in range(n):
             
            # Find ending point for current
            # subarray with distinct elements.
            while (j < n and (arr[j] not in s)):
                s.append(arr[j])
                j += 1
     
            # Calculating and adding all possible
            # length subarrays in arr[i..j]
            ans += ((j - i) * (j - i + 1)) // 2
     
            # Remove arr[i] as we pick new
            # starting point from next
            s.remove(arr[i])
     
        return ans
      


#{ 
 # Driver Code Starts
#Initial Template for Python 3



t=int(input())
for _ in range(0,t):
    n=int(input())
    a = list(map(int,input().split()))
    ob=Solution()
    ans=ob.sumoflength(a,n)
    print(ans)

# } Driver Code Ends