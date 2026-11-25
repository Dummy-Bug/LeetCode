class Solution {
    
    Map<Integer,List<Integer>> graph;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        graph = new HashMap<>();

        for (int i = 0; i < n - 1; i++){
            graph.put(i, new ArrayList<>(Arrays.asList(i + 1)));
        }

        int [] ans = new int[queries.length];
        int i = 0;

        for (int [] query : queries){
            List<Integer> edges = graph.getOrDefault(query[0] , new ArrayList<>());
            edges.add(query[1]);
            graph.put(query[0] , edges);

            ans[i] = helper(0,n-1);
            i++;
        }
        return ans;
    }

    private int helper(int start , int target){
        
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){
            
            int length = q.size();
            for (int i = 0; i < length; i++){

               int node = q.poll();

               if (node == target) return ans;

               for (int neighbor : graph.getOrDefault(node , new ArrayList<>())){

                if (!visited.contains(neighbor)){
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
               } 
            }
            ans++;
        }
        return ans;
    }
}