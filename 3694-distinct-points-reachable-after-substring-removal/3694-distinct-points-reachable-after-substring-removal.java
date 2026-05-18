class Solution {
    public int distinctPoints(String s, int k) {

        int n = s.length();

        int px = 0, py = 0;
        for (int i = 0; i < n; i++) {
            int[] d = delta(s.charAt(i));
            px += d[0];
            py += d[1];
        }

        int wx = 0, wy = 0;
        int left = 0;
        Set<Long> set = new HashSet<>();

        for (int j = 0; j < n; j++) {
            int[] d = delta(s.charAt(j));
            wx += d[0];
            wy += d[1];

            if (j - left + 1 == k) {
               long key = ((long)(px - wx) << 32) | Integer.toUnsignedLong(py - wy);
                set.add(key);
                int[] ld = delta(s.charAt(left));
                wx -= ld[0];
                wy -= ld[1];
                left++;
            }
        }

        return set.size();
    }

    private int[] delta(char ch) {
        if (ch == 'L')
            return new int[] { -1, 0 };
        if (ch == 'R')
            return new int[] { 1, 0 };
        if (ch == 'U')
            return new int[] { 0, 1 };
        return new int[] { 0, -1 };
    }
}
