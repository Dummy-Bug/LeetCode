class Solution {
    
    Integer [] dp;

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        
        dp = new Integer[nums.length];

        int [] nums1 = new int [nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++){
            nums1[i] = nums[i];
        }

        int [] nums2 = new int [nums.length - 1];
        
        for (int i = 1; i < nums.length; i++){
            nums2[i - 1] = nums[i];
        }

        int costWithoutLast = helper(nums1.length - 1 , nums1);
        Arrays.fill(dp,null);
        int costWithoutFirst = helper(nums2.length - 1, nums2);

        return Math.max(costWithoutLast , costWithoutFirst);

    }

    private int helper(int i , int [] nums){

        if (i < 0 ) return 0;

        if (dp[i] != null) return dp[i];

        int takeCurrent = nums[i] + helper(i - 2, nums);
        int skipCurrent = helper(i - 1, nums);

        return dp[i] = Math.max(takeCurrent , skipCurrent);
    }
}