class Solution {
    public int minimumDistance(int[] nums) {

        Map<Integer,Deque<Integer>> map = new HashMap<>();
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length;i++){
            Deque<Integer> q = map.getOrDefault(nums[i],new ArrayDeque<>());
            q.offer(i);

            if (q.size() == 3){
                int firstIndex = q.poll();
                int difference = 2*(i - firstIndex);
                minimumDistance = Math.min(minimumDistance,difference);
            }
            map.put(nums[i],q);
        }
        if (minimumDistance != Integer.MAX_VALUE){
            return minimumDistance;
        }
        return -1;
    }
}