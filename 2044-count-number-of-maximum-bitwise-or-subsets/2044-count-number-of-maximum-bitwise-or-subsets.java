class Solution {

    private int count = 0;
    private int maxOr = 0;

    private void helper(int i,int[] nums,int or){

        if (i == nums.length){
            if (or == maxOr){
                count++;
            }
            return;
        }

        helper(i + 1, nums, or | nums[i]);
        helper(i + 1, nums, or);
    }

    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;

        for (int i = 0; i < n; i++){
            maxOr |= nums[i];
        }

        helper(0,nums,0);
        return count;
    }
}