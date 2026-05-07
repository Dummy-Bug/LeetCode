class Solution {
    public int[] baseUnitConversions(int[][] conversions) {
        
        int n = conversions.length + 1;
        int m = conversions[0].length;

        List<int[]>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] conv: conversions){
            
            int source = conv[0];
            int target = conv[1];
            int factor = conv[2];

            edges[source].add(new int[]{target,factor});
        }

        long MOD = 1000000007L;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        int[] result = new int[n];
        result[0] = 1;

        while(!q.isEmpty()){
            int source = q.poll();

            for (int[] edge : edges[source]){
                
                int target = edge[0];
                int factor = edge[1];
                
                long conversion = (long)result[source]*factor;
                result[target] = (int)(conversion%MOD);

                q.offer(target);

            }
        }

        return result;


    }
}