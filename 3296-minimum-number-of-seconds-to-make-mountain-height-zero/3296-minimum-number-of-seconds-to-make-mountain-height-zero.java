class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[2], b[2]));

        for (int t : workerTimes) {
            pq.offer(new long[]{t, 1, t});
        }

        long ans = 0;

        while (mountainHeight-- > 0) {

            long[] cur = pq.poll();

            long t = cur[0];
            long k = cur[1];
            long sum = cur[2];

            ans = Math.max(ans, sum);

            long nextSum = sum + (k + 1) * t;

            pq.offer(new long[]{t, k + 1, nextSum});
        }

        return ans;
    }
}