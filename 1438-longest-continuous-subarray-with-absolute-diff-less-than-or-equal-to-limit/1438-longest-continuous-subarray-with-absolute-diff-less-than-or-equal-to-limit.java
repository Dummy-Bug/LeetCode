class Solution {

    public int longestSubarray(int[] nums, int limit) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0] , a[0]));

        int maxLength = 1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            while (!minHeap.isEmpty()) {
                int[] top = minHeap.peek();
                if (Math.abs(top[0] - nums[j]) > limit || top[1] < i) {
                    i = Math.max(top[1] + 1, i);
                    minHeap.poll();
                } else
                    break;
            }

            minHeap.offer(new int[]{ nums[j], j });

            while (!maxHeap.isEmpty()) {
                
                int[] top = maxHeap.peek();
                
                if (Math.abs(top[0] - nums[j]) > limit || top[1] < i) {
                    i = Math.max(top[1] + 1, i);
                    maxHeap.poll();
                } else
                    break;
            }

            maxHeap.offer(new int[] { nums[j], j });
            maxLength = Math.max(maxLength , j - i + 1);
        }
        return maxLength;

    }
}