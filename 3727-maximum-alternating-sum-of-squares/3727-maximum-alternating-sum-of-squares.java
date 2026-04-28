class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        for (int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        int i = 0; int j = nums.length-1;
        long sum=0;

        while(i < j){
            sum += nums[j]*nums[j];
            sum -= nums[i]*nums[i];
            i++;
            j--;
        }
        if (i == j){
            sum += nums[j]*nums[j];
        }
        return sum;
    }
}