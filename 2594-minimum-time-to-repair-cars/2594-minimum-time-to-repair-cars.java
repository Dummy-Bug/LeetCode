class Solution {

      private boolean helper(long budget, int[] ranks, long cars) {

          long repaired = 0;
  
          for (int r : ranks) {
              long x = budget / r;                
              long k = (long) Math.sqrt((double) x);   
              
              while ((k + 1) * (k + 1) <= x) k++;  
              while (k * k > x) k--;             

              repaired += k;
              if (repaired >= cars) return true;   
          }
          return repaired >= cars;
      }

      public long repairCars(int[] ranks, int cars) {
  
          long low = 1L;
          long high = (long) cars * cars * 100;   
          long ans = high;

          while (low <= high) {
              long mid = low + ((high - low) >> 1);

              if (helper(mid, ranks, cars)) {
                  ans = mid;
                  high = mid - 1;
              } else {
                  low = mid + 1;
              }
          }
          return ans;
      }
  }