class Solution {
    private void reverse(int [] nums, int start , int end){

        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int [] ans = new int[n + 1];
        
        for (int i = 0; i <= n ; i++) ans[i] = i + 1;

        int prevD = -1;

        for (int i = 0; i < n; i++){

            char ch = pattern.charAt(i);

            if (ch == 'D' && prevD == -1) prevD = i ;

            else if (ch == 'I' && prevD != -1){
                reverse(ans,prevD,i);
                prevD = -1;
            }
        }

        if (prevD != -1) reverse(ans,prevD,n);

        StringBuilder sb = new StringBuilder();

        for (int num : ans) sb.append(num);
        return sb.toString();
    }
}