class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        long totalSum = 0;

        long[] odd = new long  [n];
        long[] even = new long [n];

        if (((n-1)&1  )== 1){
            even[n-1] = 0L;
            odd[n-1] = nums[n-1];
        }
        else {
            even[n-1] = nums[n-1];
            odd[n-1] = 0L;
        }
        
        totalSum = nums[n-1];

        for (int i = n-2; i >= 0; i--){
            
            if ((i&1) == 1){
                even[i] = even[i+1];
                odd[i] = nums[i] + odd[i+1];
            }
            else{
                even[i] = nums[i] + even[i+1];
                odd[i] = odd[i+1];
            }
            totalSum += nums[i];
        }


        long evenSum = 0;
        long oddSum = 0;
        int count = 0;

        for (int i = 0; i < n ; i++){

            if ((i&1) == 1){
                
                long totalOddSum = oddSum + even[i];
                
                if (2*totalOddSum == (totalSum - nums[i])){
                    count++;
                }
                oddSum += nums[i];
            }
            else {

                long totalEvenSum = evenSum + odd[i];

                if (2*totalEvenSum == (totalSum - nums[i])){
                    count++;
                }
                evenSum += nums[i];
            }
        }
        return count;
    }
}