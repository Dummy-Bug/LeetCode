class Solution {
      public String pushDominoes(String dominoes) {
          int n = dominoes.length();
          char[] s = dominoes.toCharArray();
          final int INF = Integer.MAX_VALUE;

          int[] pushRight = new int[n];
          int lastR = -1;
          for (int i = 0; i < n; i++) {
              if (s[i] == 'R') lastR = i;
              else if (s[i] == 'L') lastR = -1;
              pushRight[i] = (s[i] == '.' && lastR != -1) ? i - lastR : INF;
          }

          int[] pushLeft = new int[n];
          int lastL = -1;
          for (int i = n - 1; i >= 0; i--) {
              if (s[i] == 'L') lastL = i;
              else if (s[i] == 'R') lastL = -1;
              pushLeft[i] = (s[i] == '.' && lastL != -1) ? lastL - i : INF;
          }

          char[] result = new char[n];
          for (int i = 0; i < n; i++) {
              if (s[i] != '.')               result[i] = s[i];
              else if (pushRight[i] < pushLeft[i]) result[i] = 'R';
              else if (pushLeft[i] < pushRight[i]) result[i] = 'L';
              else                            result[i] = '.';
          }
          return new String(result);
      }
  }