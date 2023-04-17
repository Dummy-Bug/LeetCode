class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        nonZeroPtr = 0; # will move if points to nonZeroElements
        zeroPtr    = 0; # will move if points to Zero
        
        while nonZeroPtr < len(nums) and zeroPtr < len(nums):
            
            if zeroPtr < nonZeroPtr:
                zeroPtr = nonZeroPtr;
                
            elif nums[nonZeroPtr] != 0:
                nonZeroPtr += 1;
            
            elif nums[zeroPtr] == 0:
                zeroPtr += 1;
            
            else:
                nums[nonZeroPtr],nums[zeroPtr] = nums[zeroPtr],nums[nonZeroPtr];
            
            # print(nonZeroPtr,zeroPtr)
        
    
        