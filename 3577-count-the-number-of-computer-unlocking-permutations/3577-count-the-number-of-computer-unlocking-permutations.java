class Solution {

    private long MOD = 1000000007L;

    public int countPermutations(int[] complexity) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < complexity.length; i++) {
            min = Math.min(min, complexity[i]);
        }
        if (min <= complexity[0]) return 0;

        return helper(complexity.length - 1);
    }

    private int helper(int n){

        long num = 1;
        for (int i = 1; i <= n; i++){
            num = (num*i)%MOD;
        }
        return (int)num;
    }
}