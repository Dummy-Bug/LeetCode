class Solution {
    public int longestSubsequence(int[] nums) {
        
        boolean nonZeroPresent = false;
        int xor = 0;
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nonZeroPresent = true;
            }
            xor = xor^nums[i];
        }
        if (xor == 0 && nonZeroPresent == false){
            return 0;
        }
        if (xor != 0){
            return nums.length;
        }else {
            return nums.length-1;
        }
    }
}