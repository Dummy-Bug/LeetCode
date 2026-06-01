class Solution {

    int [][][] dp;
    int MOD = 1000000007;

    public int countPathsWithXorValue(int[][] grid, int k) {

        int m = grid.length , n = grid[0].length;
        dp = new int[m][n][16];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return helper(m-1,n-1,k,grid);
        
    }

    private int helper(int i, int j, int x , int[][] grid){

        if (i < 0 || j < 0){
            return 0;
        }

        if (i == 0 && j == 0){
            
            if ((grid[0][0] ^ x) == 0){
                return 1;
            }
            else {
                return 0;
            }
        }

        if (dp[i][j][x] != -1){
            return dp[i][j][x];
        }

        int xor = grid[i][j] ^ x;

        int left = helper(i - 1, j , xor, grid);
        int right = helper(i, j - 1, xor , grid);

        return dp[i][j][x] = (left + right)%MOD;

    }
}