class Solution {

    record Entry(int row, int col, int health) {}

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        Set<Entry> visited = new HashSet<>();
        Queue<Entry> q = new ArrayDeque<>();

        Entry start = new Entry(0, 0, startHealth);
        q.offer(start);
        visited.add(start); 

        int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        while (!q.isEmpty()) {
            Entry entry = q.poll();
            int row = entry.row();
            int col = entry.col();
            int incomingHealth = entry.health();

           
            if (row == m - 1 && col == n - 1 && incomingHealth > 0) {
                return true;
            }

            for (int[] direction : directions) {
                
                int x = row + direction[0];
                int y = col + direction[1];

                if (isValid(x, y, m, n)) {
                   
                    int updatedHealth = incomingHealth - grid.get(x).get(y);
                    Entry next = new Entry(x, y, updatedHealth);

                    if (updatedHealth > 0 && !visited.contains(next)) {
                        visited.add(next); 
                        q.offer(next);
                    }
                }
            }
        }
        return false;
    }
}
