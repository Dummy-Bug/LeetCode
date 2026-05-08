class Solution {
    public long rob(int[] nums, int[] colors) {

        int n = nums.length;
        long [] dp = new long[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++){
            long skip = dp[i-1];
            long take = 0l;

            if (colors[i] != colors[i-1]){
                take = nums[i] + dp[i-1];
            }else {
                if (i == 1){
                    take = nums[i];
                }else{
                    take = nums[i] + dp[i-2];
                }
            }
            dp[i] = Math.max(take,skip);
        }

        return dp[n-1];

    }
}