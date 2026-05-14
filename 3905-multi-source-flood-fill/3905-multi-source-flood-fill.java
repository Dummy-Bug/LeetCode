class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        
        int[][] grid = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        Arrays.sort(sources,(a,b) -> (b[2] - a[2]));
        for (int [] edge : sources){

            int i = edge[0];
            int j = edge[1];
            int color = edge[2];

            grid[i][j] = color;
            q.offer(new int []{i,j,color});
        }
        
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){

            int [] edge = q.poll();

            int i = edge[0];
            int j = edge[1];
            int color = edge[2];

            for (int [] direction : directions){
                
                int x = i + direction[0];
                int y = j + direction[1];

                if (x < n && x >=0 && y < m && y >= 0){
                    if (grid[x][y] == 0){
                        grid[x][y] = color;
                        q.offer(new int[]{x,y,color});
                    }
                }
            }
        }
        return grid;
    }
}