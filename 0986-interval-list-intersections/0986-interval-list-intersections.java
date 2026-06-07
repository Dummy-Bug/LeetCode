class Solution {
      public int[][] intervalIntersection(int[][] firstList, int[][] secondList){
          List<int[]> out = new ArrayList<>();
          int i = 0, j = 0;
          int n = firstList.length, m = secondList.length;
          while (i < n && j < m) {
              int lo = Math.max(firstList[i][0], secondList[j][0]);
              int hi = Math.min(firstList[i][1], secondList[j][1]);
              if (lo <= hi) out.add(new int[]{lo, hi});
              if (firstList[i][1] < secondList[j][1]) i++;
              else j++;
          } 
          int[][] ans = new int[out.size()][2];
          for (int k = 0; k < out.size(); k++) {
              ans[k][0] = out.get(k)[0];
              ans[k][1] = out.get(k)[1];
          }
          return ans;
      }
  }