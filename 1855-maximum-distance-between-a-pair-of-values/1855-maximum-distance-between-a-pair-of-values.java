class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        int i = m-1,j = n-1;

        int maxDistance = 0;

        while(i >= 0 && j >= 0){

            if (nums1[i] <= nums2[j]){
                maxDistance = Math.max(maxDistance , j - i);
                i--;
            }
            else if (i < j){
                j--;
            }
            else {
                i--;
                j--;
            }
        }
        return maxDistance;
    }
}