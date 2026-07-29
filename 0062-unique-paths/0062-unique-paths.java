class Solution {
    public int uniquePaths(int m, int n) {
        
        int [] path = new int[n];

        for (int j = 0; j < n; j++){
            path[j] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){

                if (j == 1) {
                    path[j] += 1;
                    continue;
                }
                path[j] += path[j - 1];
            }
        }
        return path[n-1];
    }
}