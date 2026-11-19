class Solution {
    public int minimumSum(int[] nums) {
        
        int n = nums.length;

        if (n < 3) return -1;
        
        int [] rightMin = new int[nums.length];
        rightMin[n-1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i + 1] , nums[i]);
        }

        int minSum = Integer.MAX_VALUE;

        int minLeft = nums[0];

        for (int i = 1; i < n - 1; i++){

            if (minLeft < nums[i] && nums[i] > rightMin[i + 1]){
                minSum = Math.min(minSum , minLeft + nums[i] + rightMin[i + 1]);
            }
            minLeft = Math.min(minLeft , nums[i]);
        }
        if (minSum == Integer.MAX_VALUE) return -1;
        return minSum;
    }
}