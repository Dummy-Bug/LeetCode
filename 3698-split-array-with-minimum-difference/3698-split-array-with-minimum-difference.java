class Solution {

    private long[] leftPeak(int[] nums){
        
        int n = nums.length;
        int peak = 0;
        long leftSum = nums[peak];

        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i-1]){
                leftSum += nums[i];
                peak = i;
            }else{
                break;
            }
        }
        return new long[]{peak,leftSum};
    }

    private long[] rightPeak(int[] nums){
        
        int n = nums.length;
        int peak = n-1;
        long rightSum = nums[peak];

        for (int i = n-2; i >= 0; i--){
            if (nums[i] > nums[i+1]){
                rightSum += nums[i];
                peak = i;
            }else{
                break;
            }
        }
        return new long[]{peak,rightSum};
    }
    
    public long splitArray(int[] nums) {

        long[] leftArray = leftPeak(nums);
        long[] rightArray = rightPeak(nums);

        int leftPeak = (int)leftArray[0];
        long leftSum = leftArray[1];

        int rightPeak = (int)rightArray[0];
        long rightSum = rightArray[1];

        if (leftPeak == rightPeak){

            long optionA = Math.abs(leftSum - (rightSum - (long)nums[rightPeak]));
            long optionB = Math.abs(rightSum - (leftSum - (long)nums[leftPeak]));

            return Math.min(optionA,optionB);
        }

        else if ((leftPeak == rightPeak - 1) && (nums[leftPeak] == nums[rightPeak])){
            return Math.abs(leftSum - rightSum);
        }

        return -1L;
    }
}