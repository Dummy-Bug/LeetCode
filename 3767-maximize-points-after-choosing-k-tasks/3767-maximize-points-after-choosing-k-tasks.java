class Solution {
      public long maxPoints(int[] technique1, int[] technique2, int k) {

          int n = technique1.length;
          int[] diff = new int[n];

          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

          for (int i = 0; i < n; i++) {

              diff[i] = technique1[i] - technique2[i];

              if (pq.size() < k) {
                  pq.offer(new int[]{diff[i], i});
              } else if (k > 0 && pq.peek()[0] < diff[i]) {
                  pq.poll();
                  pq.offer(new int[]{diff[i], i});
              }
          }
  
          boolean[] forced = new boolean[n];
          while (!pq.isEmpty()) {
            forced[pq.poll()[1]] = true;
          }

          long total = 0L;
          for (int j = 0; j < n; j++) {
              if (forced[j]) total += technique1[j];
              else total += Math.max(technique1[j], technique2[j]);
          }
          return total;
      }
  }