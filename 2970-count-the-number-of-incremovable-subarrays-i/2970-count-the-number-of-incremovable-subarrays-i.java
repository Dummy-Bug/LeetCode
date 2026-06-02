class Solution {
      public int incremovableSubarrayCount(int[] nums) {

          int n = nums.length, count = 0;
          for (int i = 0; i < n; i++)
              for (int j = i; j < n; j++)
                  if (increasingAfterRemoval(nums, i, j)) count++;
          return count;
      }

      private boolean increasingAfterRemoval(int[] nums, int l, int r) {
          int prev = Integer.MIN_VALUE;
          for (int k = 0; k < nums.length; k++) {
              if (k >= l && k <= r) continue;       
              if (nums[k] <= prev) return false;   
              prev = nums[k];
          }
          return true;
      }
  }
