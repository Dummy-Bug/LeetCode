class Solution {
    public long countPairs(String[] words) {

        Map<String,Long> map = new HashMap<>();
        int MOD = 26;
        long totalPairs = 0L;


        for (String word: words){

            int n = word.length();
            char firstChar = word.charAt(0);
            int rotationFactor = firstChar - 'a';

            StringBuilder sb = new StringBuilder();
            sb.append('a');

            for (int i = 1; i < n; i++){

                char ch = word.charAt(i);
                int relativeValue = ch - 'a';
                int normalizedRelativeValue = ( relativeValue - rotationFactor + MOD )%MOD;

                char normalizedChar = (char)(normalizedRelativeValue + 'a');
                sb.append(normalizedChar);
            }

            String normalizedWord = sb.toString();
            map.put(normalizedWord , map.getOrDefault(normalizedWord,0L) + 1);
            
        }

        for (Long freq : map.values()){
            long pairs = (freq*(freq - 1))/2;

            totalPairs += pairs;
        }
        return totalPairs;
    }
    
}