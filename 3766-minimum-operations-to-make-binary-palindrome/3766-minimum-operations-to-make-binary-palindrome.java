class Solution {
  
      private boolean isBinaryPalindrome(int n) {
          String bin = Integer.toBinaryString(n);
          int i = 0, j = bin.length() - 1;
          while (i < j) {
              if (bin.charAt(i) != bin.charAt(j)) return false;
              i++;
              j--;
          }
          return true;
      }

      public int[] minOperations(int[] nums) {

          int[] ans = new int[nums.length];

          for (int i = 0; i < nums.length; i++) {

              int num = nums[i];

              if (isBinaryPalindrome(num)) {
                  ans[i] = 0;
                  continue;
              }

              for (int d = 1; ; d++) {
                
                  if (num - d > 0 && isBinaryPalindrome(num - d)) {
                      ans[i] = d;
                      break;
                  }
                  if (isBinaryPalindrome(num + d)) {
                      ans[i] = d;
                      break;
                  }
              }
          }
          return ans;
      }
  }
