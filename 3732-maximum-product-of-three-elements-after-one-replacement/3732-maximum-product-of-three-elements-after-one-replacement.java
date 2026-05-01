class Solution {
    public long maxProduct(int[] nums) {
        
        PriorityQueue<Long> pq = new PriorityQueue();

        for (int i = 0; i < nums.length; i++){

            long value = (long)Math.abs(nums[i]);
            
            if (pq.isEmpty() || pq.size() < 3){
                pq.offer(value);
            }

            else if (value > pq.peek()){
                pq.poll();
                pq.offer(value);
            }
        }
        pq.poll();
        long secondMax = pq.poll();
        long max = pq.poll();

        return max*secondMax*100000;
    }
}