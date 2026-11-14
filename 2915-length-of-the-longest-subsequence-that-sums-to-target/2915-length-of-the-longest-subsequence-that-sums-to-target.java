class Solution {

    private Integer[][] dp;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new Integer[nums.size()][target+1];

        return helper(0,target,nums);
    }

    private int helper(int i , int target , List<Integer> nums){
        
        if (target == 0) return 0;

        if (target < 0 || nums.size() == i) return -1;

        if (dp[i][target] != null) return dp[i][target];
        
        int skip = helper(i + 1, target , nums);
        int take = helper(i + 1, target - nums.get(i),nums);
        
        if (take != -1) take += 1;
        return dp[i][target] = Math.max(skip , take);
        
    }
}