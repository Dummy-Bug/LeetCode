class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> stack = new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        stack.add(new int[]{intervals[0][0],intervals[0][1]});

        int n = intervals.length;
        for (int i = 1; i < n; i++){

            int sz = stack.size();
            int[] past = stack.get(sz - 1);

            if (intervals[i][0] <= past[1]){
                stack.remove(sz - 1);
                int end = Math.max(past[1] , intervals[i][1]);
                stack.add(new int[]{past[0] , end});
            }
            else {
                stack.add(intervals[i]);
            }
        }

        int sz = stack.size();
        int [][] ans = new int[sz][2];

        for (int i = 0; i < sz; i++){

            int start = stack.get(i)[0];
            int end = stack.get(i)[1];

            ans[i][0] = start;
            ans[i][1] = end;
        }
        
        return ans;
    }
}