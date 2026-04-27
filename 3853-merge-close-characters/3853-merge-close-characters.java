class Solution {
    public String mergeCharacters(String s, int k) {
        
        List<Character> mergedChars = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length();i++){

            char ch = s.charAt(i);
            int size = mergedChars.size();

            if (!map.containsKey(ch)){
                map.put(ch,size);
                mergedChars.add(ch);
            }
            else{
                int effectiveIndex = map.get(ch);
                int difference = size - effectiveIndex;

                if(difference>k){
                    map.put(ch,size);
                    mergedChars.add(ch);
                }
            }

        }

        char[] resultArray = new char[mergedChars.size()];
        for (int i = 0; i < mergedChars.size();i++){
            resultArray[i] = mergedChars.get(i);
        }
        return new String(resultArray);
        
    }
}