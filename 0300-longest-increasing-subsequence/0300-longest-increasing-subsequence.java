class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;

        int [] tail = new int[n];

        int len = 0;

        for (int i = 0; i < n; i++){

            int num = nums[i];
            int idx = Arrays.binarySearch(tail,0,len,num);

            if (idx < 0){
                idx = -idx - 1;
            }
            tail[idx] = num;
            if (idx == len){
                
                len++;
            }
        }
        return len;
    }
}