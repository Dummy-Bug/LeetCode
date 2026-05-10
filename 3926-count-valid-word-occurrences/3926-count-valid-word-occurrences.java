 class Solution {

      private boolean isSeparator(String s, int i) {
          char ch = s.charAt(i);
          if (ch == ' ') return true;
          if (ch != '-') return false;

          int n = s.length();
          if (i == 0 || i == n - 1) return true;
  
          char prev = s.charAt(i - 1);
          char next = s.charAt(i + 1);
          return prev == ' ' || prev == '-' || next == ' ' || next == '-';
      }

      public int[] countWordOccurrences(String[] chunks, String[] queries) {
          String s = String.join("", chunks);
          int n = s.length();

          Map<String, Integer> freq = new HashMap<>();
          int start = 0;

          for (int j = 0; j < n; j++) {
              if (isSeparator(s, j)) {
                  if (start < j) {
                      String word = s.substring(start, j);
                      freq.put(word, freq.getOrDefault(word, 0) + 1);
                  }
                  start = j + 1;
              } else if (j == n - 1) {
                  String word = s.substring(start, j + 1);
                  freq.put(word, freq.getOrDefault(word, 0) + 1);
              }
          }

          int[] ans = new int[queries.length];
          for (int i = 0; i < queries.length; i++) {
              ans[i] = freq.getOrDefault(queries[i], 0);
          }
          return ans;
      }
  }