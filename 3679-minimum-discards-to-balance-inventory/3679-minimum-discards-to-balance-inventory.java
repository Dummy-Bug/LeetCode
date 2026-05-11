class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        int n = arrivals.length;
        int discardCount = 0;

        while (j < n) {

            int item = arrivals[j];

            int count = map.getOrDefault(item, 0);
            if (count + 1 > m) {
                set.add(j);
                discardCount++;
            } else {
                map.put(item, count + 1);
            }

            if (j - i + 1 == w) {
                if (!set.contains(i)){
                   map.put(arrivals[i], map.get(arrivals[i]) - 1);
                }
                i++;
            }
            j++;
        }

        return discardCount;
    }

}