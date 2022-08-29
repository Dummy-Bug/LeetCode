class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        
        map_array = [False]*(10**6);
        
        for i in range(len(nums)):
            
            map_array[nums[i]] = True;
        
        nums.sort(); moves_count = 0;
        prev_max = 0;
        
        for i in range(1,len(nums)):
            
            if nums[i] == nums[i-1]:

                prev_max = max(prev_max,nums[i]);
                
                while map_array[prev_max] != False:
                    
                    prev_max += 1;
                    
                map_array[prev_max] = True;
                moves_count += (prev_max-nums[i]);
        
        return moves_count; 
                
                
            
        