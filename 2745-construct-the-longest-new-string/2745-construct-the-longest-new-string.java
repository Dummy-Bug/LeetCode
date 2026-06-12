class Solution {
    public int longestString(int x, int y, int z) {

        if (x == y) return 4*x + 2*z;
        
        int m = Math.min(x,y);

        return 2*m + 2*(m + 1) + 2*z;
    }
}