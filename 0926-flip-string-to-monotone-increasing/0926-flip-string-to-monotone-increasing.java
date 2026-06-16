class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int [] zeroCount = new int[n];

        if (s.charAt(n - 1) == '0'){
            zeroCount[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--){

            if (s.charAt(i) == '0'){
                zeroCount[i] += zeroCount[i + 1] + 1;
            }
            else zeroCount[i] = zeroCount[i + 1];
        }

        int minFlips = n;
        int countOnes = 0;

        for (int i = 0; i < n; i++){
            
            minFlips = Math.min(minFlips , countOnes + zeroCount[i]);
            
            if (s.charAt(i) == '1'){
                countOnes += 1;
            }
        }
        minFlips = Math.min(minFlips , countOnes);
        return minFlips;

    }
}