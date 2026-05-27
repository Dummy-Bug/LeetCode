class Solution {

    private int findPosition(int[] nums, int num){
        
        int n = nums.length;

        for (int i = 0; i < n; i++){
            if (nums[i] == num){
                return i;
            }
        }
        return -1;
    }

    private void reverse(int [] nums, int k){

        int i = 0;
        int j = k;

        while( i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }
    public List<Integer> pancakeSort(int[] nums) {
        
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        while( n!= 0){
            
            int position = findPosition(nums,n);
            int requiredPosition = n - 1;
            
            if (position != requiredPosition){
                ans.add(position + 1);
                reverse(nums,position);

                ans.add(requiredPosition + 1);
                reverse(nums,requiredPosition);
            }
            n = n - 1; 
        }
        return ans;

    }
}