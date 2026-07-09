class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> ans = new ArrayList<>();
        Arrays.sort( intervals,(a,b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0] , b[0]);
            }
            else return Integer.compare(a[1] ,b[1]);
            } );

        ans.add(intervals[0]);
        int n = intervals.length;

        for (int i = 1; i < n; i++){

            int[] prev = ans.get(ans.size() - 1);

            if (prev[1] >= intervals[i][0]){
                ans.remove(ans.size() - 1);
                int end = Math.max(prev[1] , intervals[i][1]);
                ans.add(new int[]{prev[0] , end});
            }
            else {
                ans.add(intervals[i]);
            }
        }
        int size = ans.size();

        int [][] output = new int[size][2];

        for (int i = 0; i < size;i++){
            int start = ans.get(i)[0];
            int end = ans.get(i)[1];

            output[i] = new int[]{start , end};
        }
        return output;
    }
}