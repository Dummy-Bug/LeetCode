class Solution {

    private boolean isValid(int r, int c, int m, int n) {
        if (r >= m || r < 0 || c >= n || c < 0)
            return false;
        return true;
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int [][] neighbors = new int [][]{{0,-1},{0,1},{-1,0},{1,0}};
        HashSet<String> set = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;


        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int []{row , col});
        set.add(new String(""+row + col));

        while(!q.isEmpty()){

            int [] cell = q.poll();
            
            int i = cell[0];
            int j = cell[1];

            boolean isBorderCell = false;

            for (int [] adjacent : neighbors){
                
                int x = adjacent[0] + i;
                int y = adjacent[1] + j;

                if (set.contains("" + x + y)){
                    continue;
                }

                else if ( isValid(x,y,m, n) && grid[x][y] == grid[i][j]){
                    q.offer(new int[]{x , y});
                    set.add("" + x + y);
                }

                else isBorderCell = true;
            }
            if (isBorderCell){
                grid[i][j] = color;
            }
        }
        return grid;
    }
}