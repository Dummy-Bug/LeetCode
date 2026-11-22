class Solution {
    public int kthGrammar(int n, int k) {
        
        if (n == 1 || k == 1) return 0;

        int totalColumns = (int)Math.pow(2,n - 1);

        if (k >  totalColumns/2 ){
            return kthGrammar(n - 1, k - totalColumns/2) ^ 1;
        }
        return kthGrammar(n - 1, k);
    }
}