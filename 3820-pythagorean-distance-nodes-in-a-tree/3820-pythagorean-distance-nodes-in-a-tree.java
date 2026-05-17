class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        
        Map<Integer,Integer> dx = new HashMap<>();
        Map<Integer,Integer> dy = new HashMap<>();
        Map<Integer,Integer> dz = new HashMap<>();

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            List<Integer> al = graph.getOrDefault(u,new ArrayList<Integer>());
            al.add(v);
            graph.put(u,al);

            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        helper(x, graph, dx);
        helper(y, graph, dy);
        helper(z, graph, dz);

        int count = 0;

        for (int i = 0; i < n; i++){

            int u = i;

            int d1 = dx.getOrDefault(u,-1);
            int d2 = dy.getOrDefault(u,-1);
            int d3 = dz.getOrDefault(u,-1);

            if (d1 != -1 && d2 != -1 && d3 != -1){
                int[] distance = new int[]{d1,d2,d3};
                Arrays.sort(distance);

                int c = distance[2];
                int b = distance[1];
                int a = distance[0];

                if (c*c == a*a + b*b){
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(int node ,Map<Integer,List<Integer>> graph,Map<Integer,Integer> map){

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{node,0});

        while(!q.isEmpty()){
            
            int[] edge = q.poll();
            int u = edge[0];
            int distance = edge[1];

            map.put(u,distance);

            for (int neighbor : graph.getOrDefault(u,new ArrayList<Integer>())){

                if (!map.containsKey(neighbor)){
                    q.offer(new int[]{neighbor,distance + 1});
                }
            }
        }
    }
}