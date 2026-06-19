class Solution {
      public int rangeBitwiseAnd(int left, int right) {
          int shift = 0;
          while ((left >> shift) != (right >> shift)) {
              shift++;
          }
          return (left >> shift) << shift;
      }
  }