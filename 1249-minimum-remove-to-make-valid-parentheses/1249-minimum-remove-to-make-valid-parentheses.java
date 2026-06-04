class Solution {
    

    public String minRemoveToMakeValid(String s) {
        
        int n = s.length();
        boolean [] indices = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++){

            char ch = s.charAt(i);

            if (ch == '('){
                stack.push(i);
            }
            else if (ch == ')'){

                if (stack.isEmpty()){
                    indices[i] = true;
                }
                else{
                    stack.pop();
                }
            }
        }

        
        while (!stack.isEmpty()){
            int i = stack.pop();
            indices[i] = true;
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < n; i++){
            if (!indices[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}