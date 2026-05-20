class Solution {
    public long maximumScore(int[] nums, String s) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
          
          long ans = 0;
          
          for (int i = 0; i < nums.length; i++) {
              pq.offer(nums[i]);
              if (s.charAt(i) == '1') {
                  ans += pq.poll();
              }
          }
          return ans;
      }
}