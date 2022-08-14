class Solution:
    def moveZeroes(self, A: List[int]) -> None:
        
        shift = 0;
        
        for i in range(len(A)):
            
            if A[i] == 0:
                shift += 1;
            else:
                A[i-shift],A[i] = A[i], A[i-shift];
        
        