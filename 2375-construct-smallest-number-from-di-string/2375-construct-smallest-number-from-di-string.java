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

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++){

            char ch = pattern.charAt(i);

            if (ch == 'D') stack.push(i);
            else if (ch == 'I'){
                
                int j = i;
                
                while (!stack.isEmpty()){
                    j = stack.pop();
                }
                reverse(ans,j,i);
            }
        }

        int j = -1;
                
        while (!stack.isEmpty()){
            j = stack.pop();
        }
        if (j != -1) reverse(ans,j,n);

        StringBuilder sb = new StringBuilder();

        for (int num : ans) sb.append(num);
        return sb.toString();
    }
}