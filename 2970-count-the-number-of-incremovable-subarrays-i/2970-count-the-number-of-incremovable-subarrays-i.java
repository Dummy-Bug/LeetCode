class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        
        int n = nums.length;
        int left = 0;

        for (int i = 1; i < n; i++){
            if (nums[i - 1] >= nums[i]){
                break;
            }
            left = i;
        }

        if (left == n - 1){
            return (n*(n+1))/2;
        }

        int right = n - 1;
        for (int i = n - 2; i >= 0; i--){
            if (nums[i] >= nums[i + 1]){
                break;
            }
            right = i;
        }

        int count = 0;
        for (int i = left + 1; i >= 0; i--){

            if ( i!= 0 && nums[i - 1] >= nums[right]){

                int j = right;
                while ( j < n && nums[i - 1] >= nums[j] ){
                    j++;
                }
                if (j == n){
                    count = count + 1;
                }
                else {
                    count += n - j + 1;
                }
            }
            else {
                count += n - right + 1;
            }
        }
        return count;
    }
}