import java.util.Arrays;

class Solution {
    
    private Long[][][] dp;

    public long numberOfWays(String s) {
        int n = s.length();
        dp = new Long[n][4][3]; 

        return helper(0, 2, s, 3); 
    }

    private long helper(int i, int prev, String s, int count) {
        if (count == 0) return 1L;
        if (i >= s.length()) return 0L;

        if (dp[i][count][prev] != null) {
            return dp[i][count][prev];
        }

        long skip = helper(i + 1, prev, s, count);
        long take = 0L;
        int building = s.charAt(i) - '0';

        if (prev == 2 || building != prev) {
            take = helper(i + 1, building, s, count - 1);
        }

        return dp[i][count][prev] = skip + take;
    }
}