class Solution {

    public int countKthRoots(int l, int r, int k) {

        if (k == 1){
            return r - l + 1;
        }
        
        int count = 0;
        for (int i = 1; (int)Math.pow(i,k) <= r; i++){

            int power = (int)Math.pow(i,k);
            if (power <=r && power >= l){
                count++;
            }
        }

        if (l == 0){
            return count + 1;
        }
        return count;
    }
}