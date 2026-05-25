class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        

        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 1; i < m; i++){
            dp[i][0] = i + 1L + dp[i-1][0] + waitCost[i][0];
        }

        for (int j = 1; j < n; j++){
            dp[0][j] = j + 1L + dp[0][j-1] + waitCost[0][j];
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){

                long cost = waitCost[i][j];
                long entryCost = ( (long)i + 1 ) * (j + 1) ;

                dp[i][j] = Math.min( dp[i-1][j] , dp[i][j-1] ) + cost + entryCost;
            }
        }

        return dp[m-1][n-1] - waitCost[m-1][n-1];
    }
}