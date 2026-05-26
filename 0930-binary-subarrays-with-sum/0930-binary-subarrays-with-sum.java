class Solution {

    private int getSumLessThanGoal(int[] nums, int goal){

        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        int sum = 0;

        while( j < n){

            sum += nums[j];

            if (sum < goal){
                ans += j - i + 1;
            }

            else if (sum == goal){

                while( i <= j && sum == goal){
                    sum -= nums[i];
                    i++;
                }
                if (i <= j){
                     ans += j - i + 1;
                }
               
            }
            j++;
        }
        return ans;
    }

    private int getSumLessThanEqualToGoal(int[] nums, int goal){
        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        int sum = 0;

        while ( j < n ){

            sum += nums[j];

            if ( sum <= goal){
                ans += j - i + 1;
            }
            else if (sum > goal){

                while ( i <= j && sum > goal){
                    sum -= nums[i];
                    i++;
                }
                if (i <= j){
                    ans += j - i + 1;
                }
            }
            j++;
        }
        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return getSumLessThanEqualToGoal(nums,goal) - getSumLessThanGoal(nums,goal);
    }
}