class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;
        int [] preXor = new int[n];
        preXor[0] = arr[0];

        for (int i = 1; i < n; i++){
            preXor[i] = preXor[i - 1] ^ arr[i];
        }

        int xor = 0;
        int [] ans = new int [queries.length];
        int i = 0;
        for (int [] q : queries){
            
            int left = q[0];
            int right = q[1];

            if (left == 0) ans[i] = preXor[right];
            else ans[i] = preXor[right] ^ preXor[left - 1];
            i++;
            
        }
        return ans;
    }
}