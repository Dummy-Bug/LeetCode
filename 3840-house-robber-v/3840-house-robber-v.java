class Solution {
    public long rob(int[] nums, int[] colors) {

        int n = nums.length;
        long [] dp = new long[n];

        long first = nums[0];
        long second = 0;

        for (int i = 1; i < n; i++){
            long skip = first;
            long take = 0l;

            if (colors[i] != colors[i-1]){
                take = nums[i] + first;
            }else{
                take = nums[i] + second;
            }
            second = first;
            first = Math.max(take,skip);
        }

        return first;

    }
}