class Solution {
    public boolean canReorderDoubled(int[] nums) {


        int n = nums.length;
        Integer [] arr = new Integer[n];

        for (int i = 0; i < n; i++){
            arr[i] = nums[i];
        }

        Map<Integer, Deque<Integer>> map = new HashMap<>();

        Arrays.sort(arr , (a,b) -> Math.abs(a) - Math.abs(b));

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            Deque<Integer> stack = map.getOrDefault(num, new ArrayDeque<>());
            stack.push(i);
            map.put(num , stack);
        }

        Deque<Integer> st = map.getOrDefault(0, new ArrayDeque<>());

        if ( (!st.isEmpty()) && (st.size() %2 != 0) ) return false;
        
        Set<Integer> paired = new HashSet<>();
        
        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) paired.add(i);

            if (paired.contains(i)) continue;

            Deque<Integer> stack = map.getOrDefault(2 * arr[i], new ArrayDeque<>());
            if (stack.isEmpty()) return false;

            paired.add(stack.pop());
            map.put(2 * arr[i] , stack);
        }
        return true;
    }
}