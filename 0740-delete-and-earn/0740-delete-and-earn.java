class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int [] dp = new int[n];

        int maximum = 0;
        for (int i = 0; i < n; i++){
            int curr = nums[i];
            dp[i] = curr;
            for (int j = i - 1; j >= 0; j--){
                int prev = nums[j];
                if (curr != prev + 1){
                    dp[i] = Math.max(dp[i],curr + dp[j]);

                }
            }
            maximum = Math.max(maximum,dp[i]);
        }
        return maximum;
    }
}