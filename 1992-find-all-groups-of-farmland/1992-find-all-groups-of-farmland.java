class Solution {
    
    private Set<String> visited = new HashSet<>();

    private Deque<int[]> q = new ArrayDeque<>();

    private int [][] direction = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
    
    private int [] helper(int r, int c,int [][] grid){
        
        int m = grid.length;
        int n = grid[0].length;

        q.offer(new int []{r,c});

        visited.add(r+"-"+c);

        int maxRow = 0;
        int maxCol = 0;

        while(!q.isEmpty()){

            int [] land = q.poll();
            
            int x = land[0];
            int y = land[1];

            maxRow = Math.max(maxRow,x);
            maxCol = Math.max(maxCol,y);

            for (int [] neighbor : direction){
                
                int i = neighbor[0] + x;
                int j = neighbor[1] + y;

                if (i < m && j < n && i >= 0 && j >= 0){

                    if ((!visited.contains(i+"-"+j) && grid[i][j] == 1)){
                        q.offer(new int[]{i,j});
                        visited.add(i+"-"+j);
                    }
                }
            }
        }
        return new int[]{r,c,maxRow,maxCol};
    }
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){

                if (!visited.contains(i+"-"+j) && land[i][j] == 1){
                    int [] farmLand = helper(i,j,land);
                    ans.add(farmLand);
                }
            }
        }

        int totalGroups = ans.size();
        int [][] array = new int[totalGroups][4];

        for (int i = 0; i < totalGroups; i++){
            
            int [] farmLand = ans.get(i);
            
            for (int j = 0; j < 4; j++){
                array[i][j] = farmLand[j];
            }
        }
        return array;
    }
}