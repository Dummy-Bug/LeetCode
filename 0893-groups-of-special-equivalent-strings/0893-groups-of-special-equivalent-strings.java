class Solution {

    private String merge(char[] even, char [] odd){

        StringBuilder sb = new StringBuilder();
        
        int m = even.length;
        int n = odd.length;

        int i = 0;
        int j = 0;

        int length = 0;

        while (length < m + n){
            
            if ((length&1) == 1){
                sb.append(odd[j]);
                j++;
            }
            else{
               sb.append(even[i]);
               i++;
            }
            length++;
        }
       
        return sb.toString();
    }

    public int numSpecialEquivGroups(String[] words) {
        
        int n = words.length;
        Set<String> set = new HashSet<>();
        int count = 0;

        for (String word : words){

            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < word.length(); i++){

                if ((i&1) == 1){
                    odd.append(word.charAt(i));
                }
                else {
                    even.append(word.charAt(i));
                }
                System.out.println(even.length() + "_" + odd.length());
            }

            char [] oddChars = odd.toString().toCharArray();
            Arrays.sort(oddChars);

            char [] evenChars = even.toString().toCharArray();
            Arrays.sort(evenChars);

            String normalizedWord = merge(evenChars,oddChars);
            if (set.add(normalizedWord)){
                count++;
            }
        }
        return count;
    }
}