class Solution {

    private int getPrefixLength(String w1, String w2){

        int n = Math.min(w1.length(),w2.length());

        for (int i = 0; i < n; i++){
            if (w1.charAt(i) != w2.charAt(i)){
                return i;
            }
        }
        return n;
    }
    public int[] longestCommonPrefix(String[] words) {
        
        int n = words.length;

        int[] right = new int[n];
        right[n-1] = 0;

        for (int i = n-2; i >= 0; i--){
            
            String word = words[i];
            int prefixLength = getPrefixLength(word,words[i+1]);

            right[i] = Math.max(prefixLength , right[i+1]);
        }

        int[] left = new int[n];
        left[0] = 0;

        for (int i = 1; i < n; i++){

            String word = words[i];
            int prefixLength = getPrefixLength(word,words[i-1]);

            left[i] = Math.max(prefixLength , left[i-1]);
        }

        int [] answer = new int[n];

        for (int i = 0; i < n; i++){

            int leftMax = 0;
            if (i != 0){
                leftMax = left[i-1];
            }

            int rightMax = 0;
            if (i != n-1){
                rightMax = right[i+1];
            }

            int maxPrefix = Math.max(leftMax,rightMax);

            if (i != 0 && i != n-1){
                int prefixLength = getPrefixLength(words[i-1],words[i+1]);
                maxPrefix = Math.max(maxPrefix,prefixLength);
            }
            answer[i] = maxPrefix;
        }
        return answer;
    }
}