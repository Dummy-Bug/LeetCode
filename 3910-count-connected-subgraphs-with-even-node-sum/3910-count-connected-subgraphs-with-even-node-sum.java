 class Solution {
      public int evenSumSubgraphs(int[] nums, int[][] edges) {
          int n = nums.length;

          // adj[i] = bitmask of i's neighbors
          int[] adj = new int[n];
          for (int[] e : edges) {
              adj[e[0]] |= (1 << e[1]);
              adj[e[1]] |= (1 << e[0]);
          }

          int count = 0;
          for (int mask = 1; mask < (1 << n); mask++) {
              // even-sum filter
              int sum = 0;
              for (int i = 0; i < n; i++) {
                  if ((mask & (1 << i)) != 0) sum += nums[i];
              }
              if ((sum & 1) != 0) continue;
  
              // BFS using bitmasks
              int start = Integer.numberOfTrailingZeros(mask);
              int visited = 1 << start;
              Deque<Integer> q = new ArrayDeque<>();
              q.offer(start);
              
              while (!q.isEmpty()) {
                  int node = q.poll();
                  int frontier = adj[node] & mask & ~visited;
                  while (frontier != 0) {
                      int next = Integer.numberOfTrailingZeros(frontier);
                      visited |= (1 << next);
                      q.offer(next);
                      frontier &= frontier - 1;
                  }
              }

              if (visited == mask) count++;
          }
          return count;
      }
  }