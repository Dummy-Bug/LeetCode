class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int [] ans = new int[n];

        for (int [] booking : bookings){

            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int seats = booking[2];

            ans[first] = ans[first] + seats;
            if (last != n - 1){
                ans[last + 1] = ans[last + 1] - 1*seats;
            }
        }

        for (int i = 1; i < n; i++){
            ans[i] = ans[i] + ans[i - 1];
        }
        return ans;
    }
}