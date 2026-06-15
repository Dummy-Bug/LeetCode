class Solution {

    private boolean helper(long budget , int[] ranks, long cars){

        long repaired = 0;

        for (int r : ranks){
            if (r > budget) return repaired >= cars;
            repaired += (long)Math.sqrt(budget/r);
            if (repaired >= cars) return true;
        }
        return repaired >= cars;
        
    }

    public long repairCars(int[] ranks, int cars) {
        
        Arrays.sort(ranks);

        long low = 1L;
        long high = (long)cars*cars*100;

        long ans = high;

        while(low <= high){

            long mid = low + ((high-low)>>1) ;

            if (helper(mid,ranks,cars)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}