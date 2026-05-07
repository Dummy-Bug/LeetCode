class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        if (n == 1)
            return nums;
        int[] result = new int[n - k + 1];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (j < n) {
            if ((j != 0) && (nums[j] != nums[j - 1] + 1)) {
                i = j;
            }
            if (j >= k - 1) {
                if (k == j - i + 1) {
                    result[idx] = nums[j];
                    i++;
                } else {
                    result[idx] = -1;
                }
                idx++;
            }
            j++;
        }
        return result;
    }
}