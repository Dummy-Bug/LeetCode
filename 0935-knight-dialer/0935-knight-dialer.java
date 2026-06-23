class Solution {

    private Map<Integer,int[]> map = new HashMap<>();
    private long[][] dp;
    private long ans = 0L;
    private final int MOD = 1000000007;

    {   
        map.put(0, new int[]{4,6});
        map.put(1, new int[]{6,8});
        map.put(2, new int[]{7,9});
        map.put(3, new int[]{4,8});
        map.put(4, new int[]{0,3,9});
        map.put(5, new int[]{});
        map.put(6, new int[]{0,1,7});
        map.put(7, new int[]{2,6});
        map.put(8, new int[]{1,3});
        map.put(9, new int[]{2,4});
    }

    public int knightDialer(int n) {

        dp = new long[10][n + 1];
        
        for (int i = 0; i < 10; i++){
            Arrays.fill(dp[i], -1L);
        }

        for (int i = 0; i < 10; i++){
            ans = (ans + helper(i,n - 1))%MOD;
        }
    
        return (int)ans;
    }

    private long helper(int num , int target){

        if (target == 0)return 1L;
        else if (dp[num][target] != -1) return dp[num][target];

        long count = 0L;

        for (int nextNum : map.get(num)){
            count = (count + helper(nextNum ,target - 1))%MOD ;
        }
        return dp[num][target] = count;
    }

}