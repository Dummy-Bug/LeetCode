class Solution {

    public int countPathsWithXorValue(int[][] grid, int k) {
        
        int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        int [][][] dp = new int[m][n][16];
        
        for (int x = 0; x < 16; x++){

            if ( grid[0][0] == x ){
                dp[0][0][x] = 1;
            }
        }

        for (int i = 0 ; i < m; i++){
            for (int j = 0; j < n; j++){
                for (int x = 0; x < 16; x++){

                    if (i == 0 && j == 0){
                        continue;
                    }
                    int xor = grid[i][j] ^ x;

                    if (i == 0){
                        dp[0][j][x] = dp[0][j-1][xor]; 
                    }
                    else if (j == 0){
                        dp[i][0][x] = dp[i-1][0][xor];
                    }
                    else {
                        dp[i][j][x] = (dp[i-1][j][xor] + dp[i][j-1][xor])%MOD; 
                    }
                }
            }
        }

        return dp[m-1][n-1][k];
        
    }
}