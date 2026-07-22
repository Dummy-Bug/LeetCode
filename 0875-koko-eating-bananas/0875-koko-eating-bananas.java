class Solution {

    private boolean canEat(int [] piles , int h , int rate){

        int time = 0;

        for (int i = 0; i < piles.length; i++){

            time += (piles[i] + rate - 1)/rate ;
            if (time > h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        long low = 1;
        long high = 1;

        for (int num : piles){
            high = Math.max(high , (long)num);
        }

        long ans = 1;

        while(low <= high){

            long mid = (low + high)>>1;

            if (canEat(piles,h,(int)mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return (int)ans;
    }
}