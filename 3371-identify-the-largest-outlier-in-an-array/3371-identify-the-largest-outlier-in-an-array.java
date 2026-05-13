class Solution {
      public int getLargestOutlier(int[] nums) {

          int n = nums.length;
          int tSum = 0;
          Map<Integer, Integer> freq = new HashMap<>();
  
          for (int i = 0; i < n; i++) {
              tSum += nums[i];
              freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
          }
          boolean isEven = (tSum % 2 == 0) ? true : false;

          int maxOutlier = Integer.MIN_VALUE;

          for (int i = 0; i < n; i++) {

              if ((isEven && nums[i] % 2 == 0) || (!isEven && nums[i] % 2 != 0))
   {

                  int sum = (tSum - nums[i]) / 2;
                  int required = (sum == nums[i]) ? 2 : 1;
                  if (freq.getOrDefault(sum, 0) >= required) {
                      maxOutlier = Math.max(maxOutlier, nums[i]);
                  }
              }
          }
          return maxOutlier;
      }
  }

