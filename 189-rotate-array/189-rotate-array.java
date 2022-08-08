class Solution {
    public void rotate(int[] nums, int k) 
    {
        
        int n = nums.length;
        k = k%n;
        
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        
        
    }
    
    public void reverse(int[] array,int start_index,int end_index)
    {
         while (start_index <= end_index){
             
             int temp = array[start_index];
             array[start_index] = array[end_index];
             array[end_index] = temp;
             
             start_index += 1;
             end_index   -= 1;
         }
    }
}