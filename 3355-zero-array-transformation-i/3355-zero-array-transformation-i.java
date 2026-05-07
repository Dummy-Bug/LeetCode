class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;
        int [] diff = new int[n];

        for(int[] q: queries){

            int i = q[0];
            int j = q[1];
            
            diff[i] += 1;

            if (j+1 < n){
                diff[j+1] -= 1;
            }
        }
        for(int i = 1; i < n; i++){
            diff[i] = diff[i] + diff[i-1];
        }
        for (int i = 0; i < n; i++){
            if (nums[i] - diff[i] > 0){
                return false;
            }
        }
        return true;
    }
}