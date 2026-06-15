class Solution {

    private boolean helper(long budget , int[] time, int totalTrips){
        
        long count = 0;

        for (int t : time){
            count += budget/t;
            if (count >= totalTrips) return true;
        }
        return count >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        
        long low = 1;
        int max = time[0];
        for (int t : time){
            max = Math.max(t , max);
        }
        long high = (long)max * totalTrips;

        long ans = -1;
        while (low <= high){

            long mid = low + ((high - low)>>1);

            if (helper(mid , time, totalTrips)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }
}