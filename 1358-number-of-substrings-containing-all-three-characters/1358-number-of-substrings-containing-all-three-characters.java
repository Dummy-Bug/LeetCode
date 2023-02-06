class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int[] letter = new int[3];
        int count = 0;
        int res = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (letter[c1 - 'a']++ == 0) {
                count++;
            }
            while (count == 3) {
                res += len - end;
                char c2 = s.charAt(start);
                if (letter[c2 - 'a']-- == 1) {
                    count--;
                }
                start++;
            }
            end++;
        }
        return res;
    }
}