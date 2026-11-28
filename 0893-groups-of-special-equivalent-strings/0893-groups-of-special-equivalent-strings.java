class Solution {
    public int numSpecialEquivGroups(String[] words) {
        
        Set<String> set = new HashSet<>();

        for (String word : words){

            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < word.length(); i++){

                char ch = word.charAt(i);

                if ((i&1) == 1){
                    odd.append(ch);
                }
                else{
                    even.append(ch);
                }
            }

            char [] evenChar = even.toString().toCharArray();
            char [] oddChar = odd.toString().toCharArray();

            Arrays.sort(evenChar);
            Arrays.sort(oddChar);

            String evenString = new String(evenChar);
            String oddString = new String(oddChar);

            String joined = evenString + oddString;

            set.add(joined);

        }

        return set.size();
    }
}