class Solution {
    public int minimumPartition(String s, int k) {

        long curr = 0;
        int parts = 1;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            if (digit > k) {
                return -1;
            }

            long next = curr * 10 + digit;

            if (next <= k) {
                curr = next;
            } else {
                parts++;
                curr = digit;
            }
        }
        return parts;
    }
}