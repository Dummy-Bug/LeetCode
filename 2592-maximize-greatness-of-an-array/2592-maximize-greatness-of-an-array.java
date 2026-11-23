class Solution {
    public int maximizeGreatness(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length; i++){

            while(!pq.isEmpty()){
                int num = pq.poll();
                if (num > nums[i]){
                    ans += 1;
                    break;
                }
            }
            if (pq.isEmpty()) return ans;
        }
        return ans;
    }
}