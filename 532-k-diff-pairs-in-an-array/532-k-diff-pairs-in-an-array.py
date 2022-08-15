class Solution:
    def findPairs(self, A: List[int], B: int) -> int:


        i = 0; j = 0;
        result = 0;
        A.sort();

        while j < len(A) and i < len(A):
            
            if i == j:
                j += 1; continue;

            difference = A[j] - A[i];

            if difference < B:
                j += 1; continue;
            
            if difference > B:
                i += 1; continue;
            
            result += 1;
            x = A[i]; y = A[j];

            while i<len(A) and A[i] == x:
                i += 1;
            while j<len(A) and A[j] == y:
                j += 1;

            
    
        return result;
                

