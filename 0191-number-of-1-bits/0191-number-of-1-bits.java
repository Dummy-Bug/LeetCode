class Solution {
    public int hammingWeight(int n) {
        
        int setBits = 0;
        final int BASE = 2;

        while (n > 0){
            setBits += n%BASE;
            n = n/BASE;
        }
        return setBits;
    }
}