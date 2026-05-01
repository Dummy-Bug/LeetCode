class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        
        Map<String,Integer> map = new HashMap<>();

        int n = s.length();
        int m = n/k;

        for(int i = 0; i < n; i += m){

            String sub = t.substring(i,i+m);
            map.put(sub,map.getOrDefault(sub,0) + 1);

        }

        for(int i = 0; i < n; i+= m){

            String sub = s.substring(i,i+m);
            if (!map.containsKey(sub)) return false;

            int freq = map.get(sub);
            if (freq == 0) return false;
            map.put(sub,freq-1);
        }
        return true;
    }
}