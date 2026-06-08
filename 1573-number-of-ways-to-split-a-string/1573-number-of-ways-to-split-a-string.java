class Solution {
    public int numWays(String s) {
        
        int count = 0;

        for (char c : s.toCharArray()){

            if (c == '1'){
                count++;
            }
        }

        if ((count%3) != 0){
            return 0;
        }

        int MOD = 1000000007;

        if (count == 0){

            long n = (long)s.length();
            long cuts = ((n-1)*(n-2))/2;
            return (int)(cuts%MOD);
        }


        int ones = 0;
        int maxOnes = count / 3;

        long cuts = 1L;
        int prevOne = -1;

        for (int i = 0; i < s.length(); i++){

            char c  = s.charAt(i);
            
            if (c == '1'){
                ones += 1;
                if (ones == maxOnes){
                    prevOne = i;
                }
            }
            if (ones > maxOnes){
                cuts = (cuts * (i - prevOne))%MOD;
                ones = 1;
                if (ones == maxOnes){
                    prevOne = i;
                }
            }
        }
        return (int)cuts;
    }
}