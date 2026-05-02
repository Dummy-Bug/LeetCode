class Solution {
    private long minimumOperations(int nums [],int k){
        
        long count = 0;

        for (int num : nums){
            count = count + (long)Math.ceil((double)num/k);
        }
        return count;
    }

    public int minimumK(int[] nums) {
        
        int low = 1;
        int high = 100000;

        int answer = 0;

        while (low <= high){

            int mid = (low + high)/2;
            long minOps = minimumOperations(nums,mid);
            if (minOps <= (long)mid*mid){
                answer = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return answer;
    }
}