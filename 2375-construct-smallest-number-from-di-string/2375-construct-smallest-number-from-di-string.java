class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] res = new char[n + 1];
        for (int i = 0; i <= n; i++) res[i] = (char) ('1' + i);

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && pattern.charAt(j) == 'D') j++;
            reverse(res, i, j);
            i = Math.max(j, i + 1);
        }
        return new String(res);
    }

    private void reverse(char[] a, int lo, int hi) {
        while (lo < hi) {
            char t = a[lo]; a[lo] = a[hi]; a[hi] = t;
            lo++; hi--;
        }
    }
}