class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();

        int count = 0;
        int ans = 0;

        for (int i = n - 1; i >= 0; i--){
            if (directions.charAt(i) == 'L'){
                count++;
                continue;
            }
            ans = ans + count;
            count = 0;
        }
        count = 0;

        for (int i = 0; i < n; i++){

            if (directions.charAt(i) == 'R'){
                count++;
                continue;
            }
            ans = ans + count;
            count = 0;
        }
        return ans;
    }
}