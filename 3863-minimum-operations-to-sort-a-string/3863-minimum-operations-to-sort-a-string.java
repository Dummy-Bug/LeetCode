class Solution {
    public int minOperations(String s) {
        
        if (isSorted(s)) {
            return 0;
        };

        int n = s.length();
        
        if (n == 2){
            return -1;
        }

        char min = 'z';
        char max = 'a';

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) < min ){
                min = s.charAt(i);
            }
            if (s.charAt(i) > max ){
                max = s.charAt(i);
            }
        }

        if (min == s.charAt(0) || max == s.charAt(n-1)){
            return 1;
        }
        else if (s.lastIndexOf(max) == 0 && s.indexOf(min) == n - 1){
            return 3;
        }
        else {
            return 2;
        }
    }

    private boolean isSorted(String s) {
        
        int n = s.length();

        for (int i = 1; i < n; i++){
            
            if (s.charAt(i) - 'a' < s.charAt(i-1) - 'a' ){
                return false;
            }
        }
        return true;
    }
}