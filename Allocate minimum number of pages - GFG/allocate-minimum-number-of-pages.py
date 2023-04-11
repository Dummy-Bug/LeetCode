class Solution:
    
    # Function to find minimum number of pages.
    
    
    def canAssign(self,bookArray,numStudents,numPages):
        
        studentCount = 0; pageCount = 0;
        
        for i in range(len(bookArray)):
            pageCount += bookArray[i];
            
            if pageCount > numPages:
                studentCount += 1;
                
                if studentCount >= numStudents:
                    return False;
                pageCount = bookArray[i];
        return True
        
        
    def findPages(self,A, N, M):
        # code here
        
        if M>N:
            return -1;
        low = max(A); high = sum(A); ans = -1;
        
        
        while low<=high:
            
            mid = (low + high)//2;

            if self.canAssign(A,M,mid):
                
                ans = mid;
                high = mid - 1;
            else:
                low = mid + 1;
        return ans;




#{ 
 # Driver Code Starts
#Initial Template for Python 3

#contributed by RavinderSinghPB
if __name__=='__main__':
    t=int(input())
    for _ in range(t):
        
        n=int(input())
        
        arr=[int(x) for x in input().strip().split()]
        m=int(input())
        
        ob=Solution()
        
        print(ob.findPages(arr,n,m))
# } Driver Code Ends