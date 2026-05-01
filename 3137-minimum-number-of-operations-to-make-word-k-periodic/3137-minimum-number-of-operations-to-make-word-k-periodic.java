class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        int n = word.length();
        int maxCount = 0;

        for (int i = 0; i < n; i += k){

            String substring = word.substring(i,i+k);
            map.put(substring,map.getOrDefault(substring,0) + 1);

            maxCount = Math.max(maxCount,map.get(substring));
        }

        int total = (int)n/k; 
        return total-maxCount;
    }
}