import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private int time;
    private List<List<Integer>> bridges;
    private int[] lowestTime;
    private int[] discoveryTime;
    private boolean[] visited;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        lowestTime = new int[n];  // self.lowestTime represents lowest time in all the adjacent nodes.
        discoveryTime = new int[n];
        visited = new boolean[n];
        bridges = new ArrayList<>();
        time = 0;

        return dfs(0, -1);
    }

    private List<List<Integer>> dfs(int src, int parent) {
        lowestTime[src] = discoveryTime[src] = time;
        time++;
        visited[src] = true;

        for (int dst : graph[src]) {
            if (dst == parent) continue;
            if (!visited[dst]) {
                dfs(dst, src);
                // now the dfs(dst) has completed done and dusted;
                lowestTime[src] = Math.min(lowestTime[src], lowestTime[dst]);
                if (lowestTime[dst] > discoveryTime[src]) {
                    // if lowest reachable time of adjacent node is
                    // more than discovery/insertion time of current node
                    // then it means there is no other way of reaching to 
                    // adjacent node without current src node;
                    bridges.add(Arrays.asList(src, dst));
                }
            } else {
                // if dst is already visited then obviously bridge is
                // not possible so just update the lowestTime[src];
                // taking here discovery time , we could have taken both
                // lowestTime here as well and it would work fine
                // but taking discovery time make more sense and is
                // the same concept in Articulation Point
                lowestTime[src] = Math.min(lowestTime[src], discoveryTime[dst]);
            }
        }
        return bridges;
    }
}
