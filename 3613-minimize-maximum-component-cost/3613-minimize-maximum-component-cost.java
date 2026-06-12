class Solution {

    class DSU {
        int parent[];
        int size[];

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            build(n);
        }

        private void build(int n){

            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int getParent(int node){

            if (parent[node] == node){
                return node;
            }
            return parent[node] = getParent(parent[node]);
        }

        public int getSize(int node){
            return size[node];
        }

        public void union(int x, int y){

            int px = getParent(x);
            int py = getParent(y);

            if (px == py)return;

            int sx = getSize(px);
            int sy = getSize(py);

            if (sx >= sy){
                sx += sy;
                parent[py] = px;
            }
            else{
                sy += sx;
                parent[px] = py;
            }
        }

        public boolean isCycle(int x , int y){
            return getParent(x) == getParent(y);
        }

    }

    public int minCost(int n, int[][] edges, int k) {
        
        Arrays.sort(edges , (a,b) -> Integer.compare(a[2] , b[2]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[2] , a[2]));

        DSU dsu = new DSU(n);

        for (int [] edge : edges){

            if (!dsu.isCycle(edge[0] , edge[1])){
                dsu.union(edge[0] , edge[1]);
                pq.offer(new int []{ edge[0] , edge[1] , edge[2] });
            }
        }
        while (k-- != 1 && !pq.isEmpty()){
            pq.poll();
        }
        if (!pq.isEmpty()){
            return pq.poll()[2];
        }
        return 0;
    }
}