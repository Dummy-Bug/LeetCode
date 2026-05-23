class Solution {
    public long rob(int[] nums, int[] colors) {
        
        int n = nums.length;
        if (n == 1){
            return (long)nums[0];
        }

        long secondPrev = (long)nums[0];
        long firstPrev = colors[0] != colors[1] ? (long)nums[0] + nums[1] : Math.max(nums[0],nums[1]);

        for (int i = 2; i < n; i++){
            
            long current = 0L;
            
            if (colors[i] == colors[i-1]){
                current = Math.max(firstPrev,nums[i] + secondPrev);
            }
            else{
                current = nums[i] + firstPrev;
            }
            secondPrev = firstPrev;
            firstPrev = current;
        }
        return firstPrev;
    }
}