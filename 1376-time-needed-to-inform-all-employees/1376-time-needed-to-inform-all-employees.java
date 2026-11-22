class Solution {

    Map<Integer, List<Integer>> tree;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        tree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (manager[i] == -1)
                continue;

            List<Integer> subordinates = tree.getOrDefault(manager[i], new ArrayList<>());
            subordinates.add(i);
            tree.put(manager[i], subordinates);
        }

        return helper(headID, informTime);
    }

    private int helper(int head, int[] informTime) {

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { head, informTime[head]});

        int ans = 0;

        while (!q.isEmpty()) {

            int [] entry = q.poll();
            head = entry[0];
            int time = entry[1];

            for (int employee : tree.getOrDefault(head, new ArrayList<>())) {
                if (informTime[employee] != 0) {
                    q.offer(new int[ ]{employee, time + informTime[employee]});
                }
            }
            ans = Math.max(ans , time);
        }
        return ans;
    }
}