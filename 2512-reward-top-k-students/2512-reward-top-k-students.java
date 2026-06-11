class Solution {
    public List<Integer> topStudents(String[] positive_feedback,
                                     String[] negative_feedback,
                                     String[] report,
                                     int[] student_id,
                                     int k) {

        Set<String> positive = new HashSet<>();
        Set<String> negative = new HashSet<>();

        for (String s : positive_feedback) {
            positive.add(s);
        }

        for (String s : negative_feedback) {
            negative.add(s);
        }

        // score, id
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];     
                }
                return b[1] - a[1];          
            }
        );

        for (int i = 0; i < report.length; i++) {
            int score = 0;

            for (String word : report[i].split(" ")) {
                if (positive.contains(word)) {
                    score += 3;
                } else if (negative.contains(word)) {
                    score -= 1;
                }
            }

            pq.offer(new int[]{score, student_id[i]});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }

        Collections.reverse(ans);

        return ans;
    }
}