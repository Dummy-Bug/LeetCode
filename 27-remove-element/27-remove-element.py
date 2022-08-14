class Solution:

    def removeElement(self, A, B):
        
        shift = 0;
        
        for i in range(len(A)):
            
            if A[i] == B:
                shift += 1;
            else:
                A[i-shift] = A[i];
        
        return len(A)-shift;