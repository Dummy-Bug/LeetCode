class Solution {

    private int helper(int [] nums){
        
        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++){
            
            int takeCurrent = nums[i] + prev2;
            int skipCurrent = prev1;

            int max = Math.max(takeCurrent, skipCurrent);

            prev2 = prev1;
            prev1 = max;
        }
        return prev1;
    }
    
    
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];

        int [] nums1 = new int [n];
        for (int i = 0; i < n - 1;i++){
            nums1[i] = nums[i];
        }
        
        int withoutLast = helper(nums1);

        int [] nums2 = new int [n];
        for (int i = 1; i < n; i++){
            nums2[i - 1] = nums[i];
        }

        int withoutFirst = helper(nums2);

        return Math.max(withoutLast , withoutFirst);

        
    }
}