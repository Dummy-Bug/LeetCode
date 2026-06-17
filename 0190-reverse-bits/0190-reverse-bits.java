class Solution {
    public int reverseBits(int n) {
      
      int i = 0, j = 31, num = 0;
      
      while (i < j) {
          
          int b1 = (n >> i) & 1;
          int b2 = (n >>> j) & 1;
          
          num += b1 * (1 << j);
          num += b2 * (1 << i);
          
          i++;
          j--;
      }
      return num;
  }

}