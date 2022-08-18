class Solution:
    def longestOnes(self, A: List[int], B: int) -> int:
        
        longest_segment_length = 0;
        zero_count = 0;
        
        p1 = p2 = 0;
        
        while (p2<len(A)):
            
            if A[p2] == 0:
                zero_count += 1;
            
            if zero_count <= B:
                longest_segment_length = max(p2-p1+1,longest_segment_length);
                p2 += 1;
                
            else:
                while zero_count>B:
                    if A[p1] == 0:
                        zero_count -= 1;
                    p1 += 1;
                
                p2 += 1;
        
        return longest_segment_length;
                        
            
        
