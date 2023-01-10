class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        min_num   = float('inf');
        max_num   = float('-inf');
        flag = False;
        
        for i in range(1,len(nums)):
            if nums[i] < nums[i-1]:
                flag = True;
            
            if flag == True:
                min_num = min(min_num,nums[i]);
        if not flag:
            return 0;
        flag = False;
        
        for i in range(len(nums)-2,-1,-1):
            if nums[i] > nums[i+1]:
                flag = True;
            if flag:
                max_num = max(max_num,nums[i]);
        print(min_num,max_num);
        for i in range(len(nums)):
            if nums[i]>min_num:
                left = i;
                break;
        for i in range(len(nums)-1,-1,-1):
            if nums[i]<max_num:
                right = i;
                break;
        return right-left+1
            
            
        