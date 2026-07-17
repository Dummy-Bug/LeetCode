class Solution {
    public int maxSubarraySumCircular(int[] nums) {
    int total = 0;

    int currMax = 0, maxSum = Integer.MIN_VALUE;
    for (int n : nums) {
        currMax += n;
        maxSum = Math.max(maxSum, currMax);
        if (currMax < 0) currMax = 0;
        total += n;
    }

    if (maxSum < 0) return maxSum;

    int currMin = 0, minSum = Integer.MAX_VALUE;
    for (int n : nums) {
        currMin += n;
        minSum = Math.min(minSum, currMin);
        if (currMin > 0) currMin = 0;
    }

    return Math.max(maxSum, total - minSum);
}
}