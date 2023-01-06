class Solution:

    def getPermutation(self, n: int, k: int) -> str:
    
        nums = []
    
        for i in range(1,n+1):
            
            nums.append(i)
        
        permutation = ""
        
        k = k - 1         # because we will consider Zero based indices    
        n = len(nums)
        
        while n > 0:
            
            n = n - 1
        
            size_of_each_block = self.fact(n)
            block_number = k//size_of_each_block # block number will give us the index
            curr_number  = nums[block_number]
            
            k = k%size_of_each_block
            permutation += str(curr_number)
            nums.remove(curr_number)
        
        return permutation
    
    def fact(self,n):
        
        if n == 1 or n == 0:
            return 1
        
        return n*self.fact(n-1)
    
            
        
        