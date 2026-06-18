class Solution {
    public int countTriplets(int[] arr) {
        
        int count = 0;
        int n = arr.length;

        for (int i = 0 ; i < n - 1; i++){
            int xor = arr[i];
            for (int k = i + 1; k < n; k++){
                xor ^= arr[k];
                if (xor == 0) count += (k-i);
            }
        }
        return count;
    }
}