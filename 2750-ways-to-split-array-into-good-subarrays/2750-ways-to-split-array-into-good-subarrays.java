class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {

        int MOD = 1000000007;
        
        int n = nums.length;
        int i ;
        for (i = 0; i < n; i++){
            if (nums[i] == 1){
                break;
            }
        }

        if (i == n){
            return 0;
        }
        
        int j = i + 1;
        long count = 1L;

        while (j < n){

            if (nums[j] == 1){
                count = ( count * (j - i) )%MOD;
                i = j;
            }
            j++;
        }

        return (int)count;
    }
}