class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int result = nums.length+1;
        int i=0,j=0;
        long curr_sum = 0;
        
        while ( j<nums.length )
        {
            curr_sum += (long)nums[j];
            
            if ( curr_sum < target )
            {
                j += 1;continue;
            }
            
            while (curr_sum >= target )
            {
                result   = Math.min(result,j-i+1);
                curr_sum = curr_sum - (long)nums[i];
                i += 1;
            }
            j += 1;
            
        }
        if ( result == nums.length + 1 )
        {
            return 0;
        }
        return result;
    }
}