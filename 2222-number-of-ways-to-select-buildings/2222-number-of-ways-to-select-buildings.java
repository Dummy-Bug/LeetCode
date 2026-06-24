
class Solution {
    
    public long numberOfWays(String s) {
      int n = s.length();
      long totalZero = 0, totalOne = 0;
      for (int i = 0; i < n; i++) {
          if (s.charAt(i) == '0') totalZero++; else totalOne++;
      }

      long leftZero = 0, leftOne = 0;
      long ans = 0;
      
      for (int i = 0; i < n; i++) {

          if (s.charAt(i) == '1') {
              long rightZero = totalZero - leftZero;
              ans += leftZero * rightZero;
              leftOne++;
          } 
          else {
              long rightOne = totalOne - leftOne;
              ans += leftOne * rightOne;
              leftZero++;
          }
      }
      return ans;
  }
}