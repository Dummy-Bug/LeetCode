class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);

        distance[k] = 0;

        // Bellman-Ford relaxation
        for (int i = 1; i <= n - 1; i++) {
            for (int[] edge : times) {
                int source = edge[0];
                int target = edge[1];
                int time = edge[2];

                if (distance[source] != (int) 1e9
                        && distance[source] + time < distance[target]) {
                    distance[target] = distance[source] + time;
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) { 
            if (distance[i] >= (int) 1e9)
                return -1;
            maxTime = Math.max(maxTime, distance[i]);
        }

        return maxTime;
    }
}
