class Solution {

    private Long [][]dp;

    public long maxScore(int[] a, int[] b) {
        this.dp = new Long[a.length][b.length];
        return dfs(0, 0, a, b);
    }

    private long dfs(int i, int j, int[] a, int[] b) {

        if (i == a.length)
            return 0;
        if (j == b.length)
            return Long.MIN_VALUE;

        if (this.dp[i][j] != null) return this.dp[i][j];

        long skip = dfs(i, j + 1, a, b);
        long take = dfs(i + 1, j + 1, a, b);
        if (take != Long.MIN_VALUE) {
            take = take + (long) a[i] * b[j];
        } else {
            take = Long.MIN_VALUE;
        }
        return this.dp[i][j] = Math.max(take, skip);
    }
}