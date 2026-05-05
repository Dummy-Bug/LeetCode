class Solution {
    public int finalElement(int[] nums) {
        
        int n = nums.length;

        int left = nums[0];
        int right = nums[n-1];

        int extremeMax = Math.max(left,right);
        int maxEle = 0;
        
        for (int i = 0; i < n; i++){
            maxEle = Math.max(nums[i],maxEle);
        }
        if (extremeMax == maxEle) return extremeMax;
        return extremeMax;
    }
}