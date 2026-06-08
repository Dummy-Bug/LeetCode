class Solution {
    public int numWays(String s) {
        
        int count = 0;

        for (char c : s.toCharArray()){

            if (c == '1'){
                count++;
            }
        }

        int MOD = 1000000007;

        if (count == 0){

            long n = (long)s.length() - 2L;
            return (int) (( (n*(n+1)) / 2) % MOD);
        }

        if ((count%3) != 0){
            return 0;
        }
        int ones = 0;
        int maxOnes = count / 3;

        long splits = 1L;
        long split = 0L;

        for (char c : s.toCharArray()){

            if (c == '1'){
                ones += 1;
            }
            if (ones == maxOnes){
                split += 1;
            }
            else if (ones > maxOnes){
                ones = 1;
                splits = (splits * split)%MOD;
                split = 0;
                if (ones == maxOnes){
                    split = 1;
                }
            }
        }
        return (int)splits;
    }
}