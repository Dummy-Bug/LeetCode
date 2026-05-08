class Solution {
    public long rob(int[] nums, int[] colors) {

        int n = nums.length;
        long [] dp = new long[n];
        Arrays.fill(dp,-1);

        return helper(nums,colors,dp,n-1);
        
    }

    private long helper(int[] nums, int[] colors, long[] dp , int index){
        if (index < 0){return 0l;}

        if (dp[index] != -1){return dp[index];}

        long skip = helper(nums,colors,dp,index-1);
        long take = 0l;

        if (index != 0 && colors[index] != colors[index-1]){
            take = nums[index] + helper(nums,colors,dp,index-1);
        }else{
            take = nums[index] + helper(nums,colors,dp,index-2);
        }
        dp[index] = Math.max(skip,take);
        return dp[index];
    }
}