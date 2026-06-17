class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.highestOneBit(n) == Integer.lowestOneBit(n);
    }
}