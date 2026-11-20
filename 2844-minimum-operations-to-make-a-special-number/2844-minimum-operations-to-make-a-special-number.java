class Solution {

    private int getPosition(Character ch , int index , Map<Character,Stack<Integer>> map){

        Stack<Integer> stack = map.getOrDefault(ch , new Stack<>());

        while(!stack.isEmpty()){

            int top = stack.peek();
            if (top >= index) {
                stack.pop();
                continue;
            }
            return top;
        }

        return -2;
    }

    public int minimumOperations(String num) {
    
    Map<Character,Stack<Integer>> map = new HashMap<>();
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    map.put('0' , st);

    for (int i = 0; i < num.length(); i++){

        Character ch = num.charAt(i);

        Stack<Integer> stack = map.getOrDefault(ch  , new Stack<>());
        stack.push(i);
        map.put(ch , stack);
    }


    int minDeletion = Integer.MAX_VALUE;
    int maxIndex = -1;

    int count = 0;
    
    for (int i = num.length() - 1; i >= 0; i--){

        if (i == maxIndex) return minDeletion;

        Character ch = num.charAt(i);
        int digit = ch - '0' - 0;

        if (digit == 0){

            int pos1 = getPosition('5' , i , map);
            minDeletion = Math.min(minDeletion , (i - pos1 - 1) + count);

            int pos2 = getPosition('0' , i , map);
            minDeletion = Math.min(minDeletion , (i - pos2 - 1) + count);

            maxIndex = Math.max(maxIndex ,Math.max(pos1 , pos2));
            
        }
        else if (digit == 5){

            int pos1 = getPosition('2' , i , map);
            minDeletion = Math.min(minDeletion , (i - pos1 - 1) + count);

            int pos2 = getPosition('7' , i , map);
            minDeletion = Math.min(minDeletion , (i - pos2 - 1) + count);

            maxIndex = Math.max(maxIndex ,Math.max(pos1 , pos2));
        }
        count++;
    }

    if (minDeletion == Integer.MAX_VALUE) return count;
    return minDeletion;

    }
}