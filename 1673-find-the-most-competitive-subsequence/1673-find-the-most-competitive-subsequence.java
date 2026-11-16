class Solution {

    public int[] mostCompetitive(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i <= nums.length - k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int[] result = new int[k];
        int resIdx = 0;
        int start = 0;
        int end = nums.length - k;

        while (resIdx != k) {
            
            int[] candidate = pq.poll();
            
            if (start <= candidate[1] && candidate[1] <= end) {
                result[resIdx++] = candidate[0];
                start = candidate[1] + 1;
                end++;
                if (end < nums.length) {
                    pq.offer(new int[]{nums[end], end});
                }
            }
        }
        return result;
    }
}