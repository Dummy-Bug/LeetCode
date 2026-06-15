class Solution {
    public int maxWidthRamp(int[] nums) {
        
        Map<Integer,Deque<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            Deque<Integer> q = map.getOrDefault(nums[i] , new ArrayDeque<>());
            q.offer(i);
            map.put(nums[i] , q);
        }

        Arrays.sort(nums);

        int ans = 0;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            Deque<Integer> q = map.get(nums[i]);
            int index = q.poll();

            ans = Math.max(ans , index - minIndex);
            minIndex = Math.min(minIndex, index);
            map.put(nums[i] , q);
        }

        return ans;

    }
}