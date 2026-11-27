class Solution {

    public int movesToMakeZigzag(int[] nums) {

        int n = nums.length;

        int[] cost = new int[2];

        for (int i = 0; i < n; i++) {

            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;

            cost[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
        }
        return Math.min(cost[0], cost[1]);
    }
}