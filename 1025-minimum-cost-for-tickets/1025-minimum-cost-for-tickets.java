class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        dp[n] = 0; // base case

        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            // 1-day pass
            while (j < n && days[j] < days[i] + 1) j++;
            int oneDay = costs[0] + dp[j];

            // 7-day pass
            j = i;
            while (j < n && days[j] < days[i] + 7) j++;
            int sevenDay = costs[1] + dp[j];

            // 30-day pass
            j = i;
            while (j < n && days[j] < days[i] + 30) j++;
            int thirtyDay = costs[2] + dp[j];

            dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }
        return dp[0];
    }
}
