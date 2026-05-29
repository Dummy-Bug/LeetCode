class Solution {
    
    int [][] dp;

    public int countVowelStrings(int n) {
        dp = new int[n + 1][5];

        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(n, 0);
    }

    private int helper(int length, int prev) {

        if (length == 1){
            return 5 - prev;
        }

        if (dp[length][prev] != -1){
            return dp[length][prev];
        }

        int sum = 0;

        for (int i = 0; i < 5; i++){

            if (prev <= i){
                sum += helper(length - 1, i);
            }
        }
        
        return dp[length][prev] = sum;
    }
}