class Solution {
    public int flipgame(int[] fronts, int[] backs) {

        Map<Integer, Boolean> map = new HashMap<>();
        int n = fronts.length;

        for (int i = 0; i < n; i++) {

            if (fronts[i] == backs[i]){
                map.put(fronts[i] , false);
                continue;
            }

            if (!map.containsKey(fronts[i])){
                map.put(fronts[i] , true);
            }
            if (!map.containsKey(backs[i])){
                map.put(backs[i] , true);
            }

        }
        
        int ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer,Boolean> entry : map.entrySet()){

            int key = entry.getKey();
            boolean value = entry.getValue();

            if (value){
                ans = Math.min(ans , key);
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}