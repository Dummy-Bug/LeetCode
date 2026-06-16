class Solution {
    final int MOD = 1_00_00_00_00_7;
    public int maximumProduct(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums){
            pq.offer(num);
        }
        while(k-- > 0){
            int num = pq.poll();
            pq.offer(num + 1);
        }

        long product = 1L;

        while(!pq.isEmpty()){
            int num = pq.poll();
            product = (product * num)%MOD;
        }
        return (int)product;
    }
}