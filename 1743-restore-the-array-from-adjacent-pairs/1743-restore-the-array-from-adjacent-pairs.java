class Solution {
    
    Map<Integer,List<Integer>> map;

    private int[] helper(int source){

        Set<Integer> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(source);
        visited.add(source);

        while(!q.isEmpty()){

            int u = q.poll();
            ans.add(u);

            for (Integer neighbor : map.get(u)){

                if (!visited.contains(neighbor)){
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }

        }
        int [] array = new int [ans.size()];
        for (int i = 0; i < ans.size(); i++){
            array[i] = ans.get(i);
        } 
        return array;
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        
        map = new HashMap<>();

        for (int[] pair : adjacentPairs){

            int u = pair[0];
            int v = pair[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int source = 0;
        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            
            if (entry.getValue().size() == 1){
                source = entry.getKey();
                break;
            }

        }
        return helper(source);
    }
}