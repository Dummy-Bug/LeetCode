class Solution {

    private boolean isVowel(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public int longestBeautifulSubstring(String word) {

        int maxLength = 0;
        int vowelCount = 0;
        Set<Character> vowelSet = new HashSet<>();

        int i = 0, j = 0, n = word.length();

        while (j < n) {

            int ch = word.charAt(j) - 'a';

            if (isVowel(word.charAt(j))) {
                vowelSet.add(word.charAt(j));
            }

            if (j <= 0 || word.charAt(j - 1) - 'a' > ch) {
                
                vowelSet.clear();
                i = j;

                if (isVowel(word.charAt(j))) {
                    vowelSet.add(word.charAt(j));
                }
            } 
            else {

                if (word.charAt(j - 1) - 'a' <= ch) {
                    if (vowelSet.size() == 5) {
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
            j++;
        }
        return maxLength;
    }
}