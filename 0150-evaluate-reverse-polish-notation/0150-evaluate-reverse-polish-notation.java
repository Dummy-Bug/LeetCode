class Solution {

    private boolean isOperator(String c){

        if (c.equals("+")  || c.equals("-") || c.equals("*") || c.equals("/")){
            return true;
        }
        return false;
    }

    private int applyOperation(int x , int y, String operator){

        if (operator.equals("+")){
            return x + y;
        }
        else if (operator.equals("-")){
            return x - y;
        }
        else if (operator.equals("*")){
            return x * y;
        }
        else {
           return x / y;
        }
    }

    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens){

            if (isOperator(s)){

                int x = stack.pop();
                int y = stack.pop(); 
                
                int z = applyOperation(y,x,s);
                stack.push(z);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}