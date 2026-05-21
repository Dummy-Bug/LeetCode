class Solution {
      public long countDistinct(long n) {
          String s = Long.toString(n);
          int L = s.length();

          // pow9[k] = 9^k
          long[] pow9 = new long[L + 1];
          pow9[0] = 1;
          for (int i = 1; i <= L; i++) pow9[i] = pow9[i - 1] * 9;

          // Part A: count no-zero positives with d digits, d = 1..L-1
          // = 9 + 9^2 + ... + 9^(L-1)
          long total = 0;
          for (int d = 1; d <= L - 1; d++) total += pow9[d];

          // Part B: walk digits of n (no-zero L-digit numbers <= n)
          boolean alive = true;
          for (int i = 0; i < L; i++) {
              int di = s.charAt(i) - '0';
              if (di == 0) { alive = false; break; }
              total += (long)(di - 1) * pow9[L - 1 - i];
          }
          if (alive) total += 1; // n itself

          return total;
      }
  }