class Solution {
    
    private boolean isOpen(char ch){

        if (ch == '{' || ch == '(' || ch == '['){
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()){

            if (isOpen(ch)){
                stack.push(ch);
            }
            else if (stack.isEmpty()){
                return false;
            }
            else if (ch == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else if (ch == ')' && stack.peek() == '('){
                stack.pop();
            }
            else if (ch == ']' && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}