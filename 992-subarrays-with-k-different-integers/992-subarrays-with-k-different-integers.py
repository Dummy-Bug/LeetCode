class Solution:
    def subarraysWithKDistinct(self, A: List[int], B: int) -> int:
        good_subarrays = 0;
        freq_map = dict();
        distinct_count = 0;
        
        p1 = p2 = 0;
        
        for i in range(len(A)):
            freq_map[A[i]] = 0;
        
        # read the notes 
        
        num_subarrays_less_than_B = 0;
        num_subarrays_less_than_equal_B = 0;
        
        while p2 < len(A):
            
            
            freq_map[A[p2]] += 1;
            
            if freq_map[A[p2]] == 1:
                distinct_count += 1;
            
            if distinct_count <= B:

                num_subarrays_less_than_equal_B += p2-p1+1;
                p2 += 1;
            else:
                # print(num_subarrays_less_than_equal_B);
                while distinct_count > B:
                    freq_map[A[p1]] -= 1;
                    
                    if freq_map[A[p1]] == 0:
                        distinct_count -= 1;
                    p1 += 1;
                
                num_subarrays_less_than_equal_B += p2-p1+1;
                p2 += 1;

        for i in range(len(A)):
            freq_map[A[i]] = 0;
            
        p1 = p2 = 0;
        distinct_count = 0;
        while p2 < len(A):
            
            
            freq_map[A[p2]] += 1;
            
            if freq_map[A[p2]] == 1:
                distinct_count += 1;
            
            if distinct_count < B:

                num_subarrays_less_than_B += p2-p1+1;
                p2 += 1;
            else:
                # print(num_subarrays_less_than_B);
                while distinct_count >= B:
                    freq_map[A[p1]] -= 1;
                    
                    if freq_map[A[p1]] == 0:
                        distinct_count -= 1;
                    p1 += 1;
                
                num_subarrays_less_than_B += p2-p1+1;
                p2 += 1;

        # print(num_subarrays_less_than_B,num_subarrays_less_than_equal_B)
        return num_subarrays_less_than_equal_B-num_subarrays_less_than_B;
                
    
        