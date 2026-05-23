class Solution {
    public long rob(int[] nums, int[] colors) {
        
        int n = nums.length;
        if (n == 1){
            return (long)nums[0];
        }
        long[] dp = new long[n];
        dp[0] = (long)nums[0];
        dp[1] = colors[0] != colors[1] ? (long)nums[0] + nums[1] : Math.max(nums[0],nums[1]);

        for (int i = 2; i < n; i++){
            if (colors[i] == colors[i-1]){
                dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
            }
            else{
                dp[i] = nums[i] + dp[i-1];
            }
        }
        return dp[n-1];
    }
}