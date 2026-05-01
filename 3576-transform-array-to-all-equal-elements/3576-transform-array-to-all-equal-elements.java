class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        
        int n = nums.length;
        int sign = 1;
        int maxAttempts = 0;

        for(int i = 0; i < n; i++){

            if( sign * nums[i] < 0){
                maxAttempts += 1;
                sign = -1;
            }else sign = 1;
        }

        if (maxAttempts <= k && sign != -1) return true;
        
        sign = 1;
        maxAttempts = 0;

        for(int i = 0; i < n; i++){

            if( sign * nums[i] > 0){
                maxAttempts += 1;
                sign = -1;
            }else sign = 1;
        }
        if (maxAttempts <= k && sign != -1) return true;
        return false;
    }
}