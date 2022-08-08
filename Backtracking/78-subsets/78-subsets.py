class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.result = [];
        
        self.helper(nums,0,[]);
        return self.result;
    
    
    def helper(self,nums,start_index,subset_list):
        
        self.result.append(list(subset_list));
    
        if start_index == len(nums):
            return
        
        for i in range(start_index,len(nums)):
            
            subset_list.append(nums[i]);
            self.helper(nums,i+1,subset_list);
            subset_list.pop();
            
        
        
            
        