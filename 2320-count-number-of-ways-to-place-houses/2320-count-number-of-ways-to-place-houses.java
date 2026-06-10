class Solution {
    final int MOD = 1000000007;
    public int countHousePlacements(int n) {
        
        long prev = 2L;
        long secondPrev = 1L;

        for (int i = 2; i <= n; i++){
            long next = (prev + secondPrev)%MOD;
            secondPrev = prev;
            prev = next;
        }
        return (int) ((prev*prev)%MOD);
    }
}