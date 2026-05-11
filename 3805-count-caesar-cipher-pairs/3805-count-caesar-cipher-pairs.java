class Solution {
    public long countPairs(String[] words) {
        
        Map<String,Integer> map = new HashMap<>();
        int MOD = 26;
        int n = words.length;
        long pairs = 0;

        for (int i = 0; i < n; i++){

            String word = words[i];

            char leader = word.charAt(0);
            int reference = (int)leader - 'a';

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < word.length(); j++){
                
                char ch = word.charAt(j);
                int normalized = (int)ch - 'a';

                int cycle = (normalized - reference + MOD)%MOD;

                int cycledChar = cycle + 'a';
                sb.append((char)cycledChar);

            }
            String root = sb.toString();
            int count = map.getOrDefault(root, 0);
            pairs += count;
            map.put(root, count + 1);
        }
        return pairs;
    } 
}