class Solution {
      public int longestSubsequence(int[] arr, int difference) {

          final int maxVal  = 10000;
          final int maxDiff = 10000;
          final int offset  = maxVal + maxDiff;
          final int size    = 2 * offset + 1;

          int[] dp = new int[size];

          int best = 0;
          for (int num : arr) {
              int normalizedNum     = num + offset;
              int prevNormalizedNum = normalizedNum - difference;
              dp[normalizedNum] = dp[prevNormalizedNum] + 1;
              best = Math.max(best, dp[normalizedNum]);
          }
          return best;
      }
  }