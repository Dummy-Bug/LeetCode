class Solution {
    public long maximumTripletValue(int[] nums) {
        
        int n = nums.length;
        int [] rightMax = new int[n];
        rightMax[n - 1] = nums[n-1];

        for (int i = n - 2; i >= 2; i--){
            rightMax[i] = Math.max(nums[i] , rightMax[i + 1]);
        }

        long ans = 0L;
        int leftMax = nums[0];

        for (int j = 1; j < n - 1; j++){

            long currMax = (leftMax - nums[j]) * (long)rightMax[j + 1] ;
            if (currMax >= 0L){
                ans = Math.max(ans , currMax);
            }
            leftMax = Math.max(leftMax , nums[j]);
        }
        return ans;
    }
}