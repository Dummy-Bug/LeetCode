class Solution {
    
    public int[][] dp;

    public int maxMoves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        int max = 0;

        for (int i = 0; i < m; i++){
            max = Math.max(max,helper(grid,i,0));
        }
        return max;
    }

    private boolean isValid(int i , int j , int m, int n){

        if (i >= 0 && i < m && j >= 0 && j < n) return true;
        return false;
    }

    private int helper(int [][] grid, int i , int j){
        
        if (dp[i][j] != -1) return dp[i][j];
        int c1 = 0,c2 = 0,c3 = 0;
        int m = grid.length;
        int n = grid[0].length;

        if (isValid(i - 1,j + 1,m,n) && grid[i - 1][j + 1] > grid[i][j]){
            c1 = 1 + helper(grid, i - 1, j + 1);
        }
        if (isValid(i , j + 1,m , n)  && grid[i][j + 1] > grid[i][j]) {
            c2 = 1 + helper(grid , i , j + 1);
        }
        if (isValid(i + 1, j + 1, m , n)  && grid[i + 1][j + 1] > grid[i][j]){
            c3 = 1 + helper(grid , i + 1 , j + 1);
        }

        return dp[i][j] = Math.max(c1,Math.max(c2,c3));
    }
}