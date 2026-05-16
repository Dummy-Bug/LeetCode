class Solution {

    int[][] dp;

    public int minRemovals(int[] nums, int target) {
        
        int n = nums.length;

        int highest = 0;
        for (int num : nums){
            highest = Math.max(highest,num);
        }

        if (highest == 0){
            if (target == highest) return 0;
            return -1;
        }

        int bitLength = 32 - Integer.numberOfLeadingZeros(highest);
        int maxXor = (1<<bitLength) - 1;

        if (target > maxXor) return -1;

        this.dp = new int[maxXor + 1][n];
        for (int i = 0; i < this.dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }

        this.helper(n-1,0,target,nums);

        if (this.dp[0][n-1] == n + 1){
            return -1;
        }
        return this.dp[0][n-1];

    }

    private int helper(int i,int currXor , int targetXor,int[] nums){

        int n = nums.length;

        if (i < 0){
            return currXor == targetXor ? 0 : n + 1;
        }

        if (this.dp[currXor][i] != -1){
            return this.dp[currXor][i];
        }

        int remove = n + 1;
        int keep = n + 1;

        int afterRemoving = helper(i-1,currXor,targetXor,nums);
        int afterKeeping = helper(i-1,currXor^nums[i],targetXor,nums);

        if (afterRemoving != n + 1){
            remove = 1 + afterRemoving;
        }
        if (afterKeeping != n + 1){
            keep = afterKeeping;
        }
        this.dp[currXor][i] = Math.min(remove,keep);
        return this.dp[currXor][i];
    }
}