class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int leftMax = -1 , rightMax = -1;
        
        int l = 0 , r = n - 1;

        int ans = 0;

        while( l <= r){

            leftMax = Math.max(height[l] , leftMax);
            rightMax = Math.max(height[r] , rightMax);

            if (leftMax <= rightMax){
                ans += leftMax - height[l];
                l++;
            }
            else{
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}