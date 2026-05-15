class Solution {
      public int uniqueXorTriplets(int[] nums) {
          int n = nums.length;
          if (n <= 2) return n;
          int bits = getBits(n);
          return 1 << bits;
      }
  
      private int getBits(int n) {
          for (int i = 31; i >= 0; i--) {
              if (((n >> i) & 1) == 1) return i + 1;
          }
          return 0;
      }
  }