class Solution {

    private int findPosition(long num  , int [] nums){
        
        int low = 0;
        int high = nums.length - 1;

        if (num < nums[low]) return low;
        if (num > nums[high]) return high + 1;

        int candidate = -1;

        while(low <= high){

            int mid = (low + high)/2 ;

            if (nums[mid] >= num){
                candidate = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return candidate;
    }


    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        int m = spells.length;
        int [] ans = new int[m];

        for (int i = 0; i < m; i++){
            long element = (spells[i] + success - 1)/spells[i] ;

            int position = findPosition(element , potions);
            ans[i] = potions.length - position;
        }
        return ans;
    }
}