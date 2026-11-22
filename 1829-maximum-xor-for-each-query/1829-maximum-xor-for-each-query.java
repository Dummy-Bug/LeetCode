class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int n = nums.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        int [] ans = new int[n];
        int max = (int)Math.pow(2,maximumBit) - 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = xor ^ max;
            xor ^= nums[i];
        }
        return ans;
    }
}