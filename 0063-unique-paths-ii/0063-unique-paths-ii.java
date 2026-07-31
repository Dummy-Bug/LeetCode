class Solution {

    Integer [][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new Integer[m][n];

        return helper(m-1,n-1,obstacleGrid);
    }

    private int helper(int i , int j , int [][] grid){

        if (i < 0 || j < 0 || grid[i][j] == 1) return 0;
        
        if ( i == 0 && j == 0 ) return 1;

        if (dp[i][j] != null) return dp[i][j];

        int top = helper(i - 1, j , grid);
        int left = helper(i , j - 1, grid);

        return dp[i][j] = top + left;
    }
}