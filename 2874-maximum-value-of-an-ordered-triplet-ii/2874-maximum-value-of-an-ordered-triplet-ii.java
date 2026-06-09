class Solution {
    public long maximumTripletValue(int[] nums) {
        
        int n = nums.length;

        long ans = 0L;
        int maxDiff = 0;

        int leftMax = nums[0];

        for (int k = 2; k < n ; k++){
            
            int j = k - 1;
            maxDiff = Math.max(maxDiff , leftMax - nums[j]);
            ans = Math.max(ans , maxDiff*(long)nums[k]);
            leftMax = Math.max(leftMax , nums[j]);
            
        }
        return ans;
    }
}