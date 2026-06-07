class Solution {
      public int eraseOverlapIntervals(int[][] intervals) {

          Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

          int lastEnd = Integer.MIN_VALUE;
          int removals = 0;

          for (int i = 0; i < intervals.length; i++) {
              
              if (intervals[i][0] >= lastEnd) {
                  lastEnd = intervals[i][1];             
              } 
              else {
                  removals++;
              }                                          
          }
          return removals;
      }                                                  
  }
