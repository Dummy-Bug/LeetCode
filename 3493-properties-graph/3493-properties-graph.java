import java.util.HashSet;
import java.util.Set;

class Solution {

    private class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            buildParent(n); 
        }

        private void buildParent(int n) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1; 
            }
        }

        public int getParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = getParent(parent[node]); 
        }

        private int getSize(int node) {
            return size[node];
        }

        public void addToGraph(int x, int y) {
            int px = getParent(x);
            int py = getParent(y);

            if (px == py) {
                return;
            }
            
            int sx = getSize(px); 
            int sy = getSize(py);

            if (sx >= sy) {
                size[px] += size[py];
                parent[py] = px; 
            } else {
                size[py] += size[px];
                parent[px] = py; 
            }
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        
        int n = properties.length; 
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            
            Set<Integer> s1 = new HashSet<>();
            for (int val : properties[i]) {
                s1.add(val);
            }
            
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                Set<Integer> s2 = new HashSet<>();

                for (int integer : properties[j]) {
                    s2.add(integer);
                }
                
                for (int val : s1) {
                    if (s2.contains(val)) {
                        count++;
                    }
                }
                if (count >= k) {
                    dsu.addToGraph(i, j); 
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.getParent(i) == i) { 
                ans += 1;
            }
        }
        return ans;
    }
}