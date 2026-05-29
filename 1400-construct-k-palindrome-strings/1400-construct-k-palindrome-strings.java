class Solution {
    public boolean canConstruct(String s, int k) {
        
        int n = s.length();
        
        if (n == k){
            return true;
        }
        else if (k > n){
            return false;
        }

        int[] chars = new int[26];

        for (int i = 0; i < n; i++){

            int ch = s.charAt(i) - 'a' ;
            chars[ch] += 1;
        }

        int oddCount = 0;
        for (int i = 0; i < 26; i++){

            if ((chars[i] & 1) == 1){
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}