class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        Arrays.sort(nums);

        int maxBeauty = 0;
        
        int i = 0;
        for (int j = 0; j < nums.length; j++){

            while( nums[j] - nums[i]  > 2*k ){
                i++;
            }
            maxBeauty = Math.max(maxBeauty , j - i + 1);
        }
        return maxBeauty;
    }
}