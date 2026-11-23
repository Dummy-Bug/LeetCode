class Solution {
    public int alternatingSubarray(int[] nums) {
        
        int right = 1;
        int left = 0;
        int maxLength = -1;

        while (right < nums.length){

            if (left == right) {
                right = right + 1;
                continue;
            }
            
            if (((right - left)&1) == 0){

                if (nums[right] - nums[left] == 0){
                    maxLength = Math.max(right - left + 1 , maxLength);
                    right++;
                }
                else {
                    left = (left == right - 1) ? right : right - 1;
                }
            }
            else{
                if (nums[right] - nums[left] == 1){
                    maxLength = Math.max(right - left + 1, maxLength);
                    right++;
                }
                else {
                    left = (left == right - 1) ? right : right - 1;
                }
            }
        }
        return maxLength;
    }
}