class Solution {
    public String mergeCharacters(String s, int k) {
        
        StringBuilder mergedChars = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int size = mergedChars.length();

            if (!map.containsKey(ch)) {
                map.put(ch, size);
                mergedChars.append(ch);
            } else {
                int effectiveIndex = map.get(ch);
                int difference = size - effectiveIndex;

                if (difference > k) {
                    map.put(ch, size);
                    mergedChars.append(ch);
                }
            }
        }

        return mergedChars.toString();
    }
}