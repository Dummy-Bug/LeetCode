class Solution {
  
      class DSU {
          int[] parent, size;

          DSU(int n) {
              parent = new int[n];
              size = new int[n];
              for (int i = 0; i < n; i++) {
                  parent[i] = i;
                  size[i] = 1;
              }
          }

          int find(int x) {
              if (parent[x] == x) return x;
              parent[x] = find(parent[x]);
              return parent[x];
          }
  
          boolean union(int x, int y) {
              int px = find(x), py = find(y);
              if (px == py) return false;

              if (size[px] < size[py]) {
                  parent[px] = py;
                  size[py] += size[px];
              } else {
                  parent[py] = px;
                  size[px] += size[py];
              }
              return true;
          }
      }

      public int minCost(int n, int[][] edges, int k) {
          Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

          DSU dsu = new DSU(n);
          int needed = n - k;
          int merges = 0;

          for (int[] e : edges) {
              if (dsu.union(e[0], e[1])) {
                  if (++merges == needed) return e[2];
              }
          }
          return 0;
      }
  }