class Solution {

    private boolean canShip(int[] weights , int maxDays, int maxWeight){

        int weight = 0;
        int days = 1;

        for (int i = 0; i < weights.length; i++){
            
            if (weight + weights[i] > maxWeight){
                weight = 0;
                days++;
            }
            weight = weight + weights[i];
            if (days > maxDays) return false;
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int low = 0;
        int high = 0;
        for (int wt : weights){
            low = Math.max(low , wt);
            high = high + wt;
        }

        int ans = -1;

        while(low <= high){

            int mid = low + ((high - low)>>1);

            System.out.println(low + " " + high + " " + mid +" ");
            if (canShip(weights,days,mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}