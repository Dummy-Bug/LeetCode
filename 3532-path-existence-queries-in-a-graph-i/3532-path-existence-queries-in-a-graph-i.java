class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] components = new int[n];
        Arrays.fill(components,-1);
        components[n-1] = n - 1;

        for (int i = 0; i < n-1; i++){

            int num = nums[i];
            int next = nums[i+1];

            int diff = nums[i + 1] - nums[i];

            if (diff <= maxDiff){

                if (components[i] != -1){
                    components[i + 1] = components[i];
                }else{
                    components[i] = i;
                    components[i+1] = i;
                }
            }
            if (components[i] == -1){
                components[i] = i;
            }
        }

        boolean [] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++){
            
            int [] q = queries[i];
            
            int u = q[0];
            int v = q[1];

            if (components[u] == components[v]){
                ans[i] = true;
            }
        }
        return ans;
        
    }
}