class Solution {
    public boolean isPowerOfFour(int n) {
        
        if (n <= 0) return false;

        int evenMask = 0x55555555;

        return ( (n & (n-1) )==0) && (( n & evenMask ) != 0);
    }
}