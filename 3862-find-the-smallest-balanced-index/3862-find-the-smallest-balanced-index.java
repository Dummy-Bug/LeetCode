class Solution {
    public int smallestBalancedIndex(int[] nums) {

        long sum = 0;
        int n = nums.length;

        for (int num : nums){
            sum += num;
        }

        long product = 1;
        int smallestIndex = n;

        for (int i = n-1; i >= 0; i--){

            sum -= nums[i];
            if (sum == product){
                smallestIndex = i;
            }
            if (sum < product){
                break;
            }
            if (product > sum/nums[i]){
                break;
                }
            product = product * nums[i];
        }

        if (smallestIndex == n){
            return -1;
        }
        return smallestIndex;
        
    }
}