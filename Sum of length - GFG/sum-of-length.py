#User function Template for python3

class Solution:
    def sumoflength(self,arr,n):
        s = set()
        j = ans = 0
        for i in range(n):
            while j < n and arr[j] not in s:
                s.add(arr[j])
                j += 1
            ans += ((j - i) * (j - i + 1)) // 2
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