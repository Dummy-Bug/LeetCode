class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        
        record Tuple(int a, int b) {}
        Set<Tuple> set = new HashSet<>();
        Arrays.sort(buildings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

       for (int i = 1; i < buildings.length - 1; i++){
            int x = buildings[i][0];
            if (x == buildings[i-1][0] && x == buildings[i+1][0]){
                set.add(new Tuple(x,buildings[i][1]));
            }
        }

       Arrays.sort(buildings, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        int answer = 0;

       for (int i = 1; i < buildings.length - 1; i++){

            int y = buildings[i][1];
            
            if (set.contains(new Tuple(buildings[i][0],y))){
                if (y == buildings[i-1][1] && y == buildings[i+1][1]){
                    answer += 1;
                }
            }
        }

        return answer;

    }
}
