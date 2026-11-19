class Solution {
    public int minDeletion(int[] nums) {
        
        int deletion = 0;
        int n = nums.length;
        int i = 0;

        while(i < n - 1){

            if (nums[i] == nums[i + 1]){
                int j = i + 1;
                while(j < n && nums[i] == nums[j]){
                    j++;
                    deletion++;
                }
                i = j + 1;
            }
            else i = i + 2;
        }

        if ((n - deletion)%2 != 0) return deletion + 1;
        return deletion;
    }
}