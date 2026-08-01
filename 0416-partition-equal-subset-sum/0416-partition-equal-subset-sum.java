class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int tSum = 0;
        for (int num : nums)
            tSum += num;

        if ((tSum & 1) == 1)
            return false;

        dp = new Boolean[nums.length][tSum / 2 + 1];

        return helper(nums.length - 1, tSum / 2, nums);
    }

    private boolean helper(int i, int sum, int[] nums) {

        if (sum == 0)
            return true;

        if (i == 0)
            return nums[i] == sum;

        if (dp[i][sum] != null)
            return dp[i][sum];

        boolean skip = helper(i - 1, sum, nums);
        boolean take = false;
        if (sum - nums[i] >= 0) {
            take = helper(i - 1, sum - nums[i], nums);
        }
        return dp[i][sum] = take || skip;
    }
}