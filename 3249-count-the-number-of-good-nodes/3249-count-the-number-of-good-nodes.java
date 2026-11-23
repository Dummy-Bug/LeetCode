class Solution {

    Map<Integer,List<Integer>> tree;
    int ans = 0;

    public int countGoodNodes(int[][] edges) {
        
        tree = new HashMap<>();

        for (int [] edge : edges){
            List<Integer> a = tree.getOrDefault(edge[0] , new ArrayList<>());
            a.add(edge[1]);
            tree.put(edge[0] , a);

            List<Integer> b = tree.getOrDefault(edge[1] , new ArrayList<>());
            b.add(edge[0]);
            tree.put(edge[1] , b);
        }

        dfs(0,-1);
        return this.ans;
    }

    private int dfs(int node ,int parent){

        Set<Integer> set = new HashSet<>();
        int size = 1;

        for (int neighbor : tree.getOrDefault(node , new ArrayList<>())){
            if (neighbor == parent) continue;

            int value = dfs(neighbor , node);
            size += value;
            set.add(value);
        }

        if (set.isEmpty() || set.size() == 1){
            this.ans += 1;
        }
        return size;
    }
}