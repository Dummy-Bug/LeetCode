class Solution {
    
    Map<Integer,Deque<Integer>> map = new HashMap<>();

    public long calculateScore(String s) {
        
        int n = s.length();
        long count = 0L;

        for (int i = 0; i < n; i++){

            char ch = s.charAt(i);
            
            int original = ch - 'a';
            int mirrored = 'z' - 'a' - original;

            if (map.containsKey(mirrored)){

                Deque<Integer> stack = map.get(mirrored);
                int j = stack.pop();
                count = count + i - j;
                
                if (stack.isEmpty()){
                    map.remove(mirrored);
                }else{
                    map.put(mirrored,stack);
                }
            }else {
                Deque<Integer> stack;
                if (map.containsKey(original)){
                    stack = map.get(original);
                }
                else {
                    stack = new ArrayDeque();
                }
                stack.push(i);
                map.put(original,stack);
            }

        }
        return count;
    }
}