class Solution {
    public int[] findOriginalArray(int[] nums) {
        
        int n = nums.length;

        if ((n&1) == 1){
            return new int[]{};
        }

        int countZero = 0;
        Map<Integer,Deque<Integer>> map = new HashMap<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++){

            int num = nums[i];

            if (num == 0){
                countZero++;
                continue;
            }
            Deque<Integer> stack;

            if (!map.containsKey(num)){
                stack = new ArrayDeque<>();
            }
            else{
                stack = map.get(num);
            }
            stack.push(i);
            map.put(num,stack);
        }

        if ((countZero%2) != 0){
            return new int[]{};
        }

        int[] ans = new int[n/2];
        int j = 0;
        for (int i = 0; i < countZero/2; i++){
            ans[j] = 0;
            j++;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = countZero; i < n; i++){

            int num = nums[i];

            if (set.contains(i)){
                continue;
            }

            if (!map.containsKey(2*nums[i])){
                return new int[]{};
            }

            Deque<Integer> stack = map.get(2*nums[i]);
            int index = stack.pop();

            if (stack.isEmpty()){
                map.remove(2*num);
            }
            else {
                map.put(2*num,stack);
            }

            set.add(index);
            ans[j] = num;
            j++;
        }
        return ans;
    }
}