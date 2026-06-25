class Solution {

    private long [] dp;
    private final int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        
        dp = new long[high + 1];

        Arrays.fill(dp, -1); 
        long lowCount = helper(low - 1, zero, one);

        Arrays.fill(dp, -1);
        long highCount = helper(high, zero , one);

        return (int)(((highCount - lowCount) % MOD + MOD) % MOD);
    }

    private long helper(int length , int zero , int one){

        if (length == 0) return 0;

        if (dp[length] != -1) return dp[length];

        long zeroCount = 0l , oneCount = 0l;

        if (length - zero >= 0){
            zeroCount = (1 + helper(length - zero, zero, one)%MOD);
        }
        if (length - one >= 0){
            oneCount = (1 + helper(length - one, zero , one%MOD));
        }
        return dp[length] = (zeroCount + oneCount)%MOD;

    }
}