class Solution {

    class Tuple {

        int temp;
        int index;

        Tuple(int temp, int index){
            this.temp = temp;
            this.index = index;
        }

    }

    public int[] dailyTemperatures(int[] temperatures) {
        
        Deque<Tuple> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int [] ans = new int[n];

        for (int i = n - 1; i >= 0; i--){

            while (!stack.isEmpty() && stack.peek().temp <= temperatures[i]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                ans[i] =  stack.peek().index - i;
            }
            else {
                ans[i] = 0;
            }
            stack.push(new Tuple(temperatures[i] , i));
        }
        return ans;
    }
}