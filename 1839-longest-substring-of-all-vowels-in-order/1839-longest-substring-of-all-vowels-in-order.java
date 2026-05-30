class Solution {
    public int longestBeautifulSubstring(String word) {

        int n = word.length(), maxLength = 0, runLen = 1, distinct = 1;

        for (int j = 1; j < n; j++) {

            char prev = word.charAt(j - 1);
            char cur = word.charAt(j);

            if (cur < prev) {
                runLen = 1;
                distinct = 1;
            } else {
                runLen++;
                if (cur > prev) {
                    distinct++;
                }
                ;
            }
            if (distinct == 5)
                maxLength = Math.max(maxLength, runLen);
        }
        return maxLength;
    }
}