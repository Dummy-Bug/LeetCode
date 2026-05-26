class Solution {
    
    int [] pre;
    int [][] dp;

    private int getSum(int i , int j){

        if (i == 0){
            return pre[j];
        }
        return pre[j] - pre[i-1];
    }

    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        pre = new int[n];
        pre[0] = piles[0];

        for (int i = 1; i < n; i++){
            pre[i] = pre[i-1] + piles[i];
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        int aliceScore =  helper(piles ,0,n-1);
        
        if (pre[n-1] - aliceScore > aliceScore){
            return false;
        }
        return true;
    }

    private int helper(int [] piles , int i , int j){

        if (i == j){
            return piles[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int s1 = helper(piles , i + 1, j);
        int s2 = helper(piles , i, j - 1);

        int tS1 = getSum(i + 1,j);
        int ts2 = getSum(i,j - 1);

        int firstPick = piles[i] + tS1 - s1;
        int lastPick = piles[j] + ts2 - s2;

        return dp[i][j] = Math.max(firstPick , lastPick);

    }
}