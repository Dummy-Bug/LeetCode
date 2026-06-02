class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String [] s1;
        String [] s2;

        if (sentence1.length() < sentence2.length()){
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        }
        else {
            s1 = sentence2.split(" ");
            s2 = sentence1.split(" ");
        }

        int m = s1.length;
        int n = s2.length;

        
        int prefixLength = 0;
        int suffixLength = 0;

        int i = 0;
        while(i < m){
            String w1 = s1[i];
            String w2 = s2[i];

            if (!w1.equals(w2)){
                break;
            }
            prefixLength++;
            i++;
        }
        
        if (prefixLength == m){
            return true;
        }

        int j = m - 1;
        int k = n - 1;
        while (j >= prefixLength){
            
            String w1 = s1[j];
            String w2 = s2[k];

            if (!w1.equals(w2)){
                break;
            }
            suffixLength++;
            j--;
            k--;
        }

        if (suffixLength == m){
            return true;
        }

        if (prefixLength + suffixLength == m){
            return true;
        }
        return false;
    }
}