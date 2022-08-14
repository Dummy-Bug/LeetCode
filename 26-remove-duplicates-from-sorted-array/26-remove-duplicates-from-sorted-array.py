class Solution:

    def removeDuplicates(self, A):
        
        i = 0; shift = 0;
        
        while i < len(A):
            
            A[i-shift] = A[i];
            
            i += 1;
            
            while i<len(A) and A[i] == A[i-1]:
                shift += 1;
                i += 1;
                        
        return len(A)-shift;
            
