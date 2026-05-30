class Solution {
    public long calculateScore(String s) {
          
          Deque<Integer>[] st = new ArrayDeque[26];
          
          for (int i = 0; i < 26; i++){
                st[i] = new ArrayDeque<>();
            }

          long count = 0;
          for (int i = 0; i < s.length(); i++) {
              
              int c = s.charAt(i) - 'a';
              int m = 25 - c;  

              if (!st[m].isEmpty()){
                count += i - st[m].pop();
              }
              else {
                st[c].push(i);
              }
          }
          return count;
      }
}