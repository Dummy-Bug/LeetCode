class Solution {
    public int reverseBits(int n) {
        
        final int BASE = 2;

        int i = 0;
        int j = 31;

        int num = 0;

        while (i < j){

            int b1 = (n>>i)&1;
            int b2 = (n>>>j)&1;

            num += b1*(int)Math.pow(BASE,j);
            num += b2*(int)Math.pow(BASE,i);

            i++;
            j--;

        }

        return num;

    }
}