class Solution {
    
    private static Long[] dp;

    public int climbStairs(int n, int[] costs) {
        
        dp = new Long[n + 1];

        return (int)helper(0 , n , costs);
    }

    private long helper(int i , int n , int [] costs){

        if (i == n) return 0;

        if (dp[i] != null) return dp[i];

        long minCost = costs[i] + 1 + helper(i + 1 , n , costs);

        if (i + 2 <= n){
            minCost = Math.min(minCost , costs[i + 1] + 4 + helper(i + 2, n , costs));
        }
        if (i + 3 <= n){
            minCost = Math.min(minCost , costs[i + 2] + 9 + helper(i + 3, n , costs));
        }
        return dp[i] = minCost;

    }
}