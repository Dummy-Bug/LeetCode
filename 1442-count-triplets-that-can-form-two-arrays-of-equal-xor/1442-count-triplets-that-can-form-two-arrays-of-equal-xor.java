class Solution {
    public int countTriplets(int[] arr) {
        
        int count = 0;
        int n = arr.length;

        for (int i = 0 ; i < n - 1; i++){
            int xori = 0;

            for (int end = i; end < n - 1; end++){
                xori ^= arr[end];
                int xorj = 0;

                for (int j = end + 1; j < n; j++){
                    xorj ^= arr[j];
                    if (xorj == xori) count++;
                }
            }
        }
        return count;
    }
}