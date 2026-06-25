class Solution {

    private int getCount(String s , int i){

        int n = s.length();
        int count = 1;

        while (i + 1 < n){
            if (s.charAt(i + 1) == s.charAt(i)) count++;
            else break;
            i++;
        }
        return count;
    }

    public int expressiveWords(String s, String[] words) {
        
        int n1 = s.length();
        int count = 0;

        for (String word : words){

            int i = 0 , j = 0;
            int n2 = word.length();

            StringBuilder sb = new StringBuilder();

            while (i < n1 && j < n2){

                char ch = word.charAt(j);

                int c1 = getCount(s,i);
                int c2 = getCount(word,j);


                if (c2 > c1) {
                    break;
                }
                else if ((c1 > c2) && (c1 < 3)){
                    break;
                }

                for (int k = 0; k < c1; k++) sb.append(ch);
                
                i += c1;
                j += c2;

            }
            if ((j == n2) && (sb.toString().equals(s))) count++;
        }
        return count;
    }
}