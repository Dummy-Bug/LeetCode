class Solution {
    public int longestBalanced(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++){

            int maxValue = Integer.MIN_VALUE;

            for(int j = i; j < s.length(); j++){

                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0) + 1);

                int minValue = Integer.MAX_VALUE;

                for (Map.Entry<Character,Integer> entry : map.entrySet()){
                    minValue = Math.min(minValue,entry.getValue());
                    maxValue = Math.max(maxValue,entry.getValue());
                }

                if (minValue == maxValue){
                    maxLength = Math.max(maxLength,minValue * map.size());
                }
            }
            map.clear();
        }
        return maxLength;
    }
}