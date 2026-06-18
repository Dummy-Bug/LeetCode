class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int ans = 0;
        for (int i = 30; i >= 0; i--){
            int setCount = 0;

            for (int num : nums){
                if (((num >> i)& 1) == 1) setCount++;
            }
            ans += setCount*(nums.length-setCount);
        }
        return ans;
    }
}