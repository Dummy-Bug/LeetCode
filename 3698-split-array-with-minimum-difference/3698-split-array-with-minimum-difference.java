class Solution {
    public long splitArray(int[] nums) {
        
        int n = nums.length;
        
        int left = 1;

        long lSum = nums[0];

        while(left < n){

            if (nums[left] > nums[left - 1]){
                lSum += nums[left];
            }else{
                break;
            }
            left++;
        }
        left--;

        int right = n-2;
        long rSum = nums[n-1];

        while(right >= 0){

            if (nums[right] > nums[right + 1]){
                rSum += nums[right];
            }
            else{
                break;
            }
            right--;
        }
        right++;

        if (left == right){

            long optionA = Math.abs(lSum - nums[left] - rSum);
            long optionB = Math.abs(lSum - (rSum - nums[right]));

            return Math.min(optionA,optionB);
        }
        else if (left + 1 == right){
            return Math.abs(lSum - rSum);
        }else{
            return -1;
        }

    }
}