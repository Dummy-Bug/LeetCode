class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int lo = 1;
        int hi = s.length();
        int result = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // can we make a valid substring of length `mid`?
            if (canMakeValidSubstring(s, mid, k)) 
            {
                // explore the right half
                lo = mid+1;
                result = mid;
            } 
            else 
            {
                // explore the left half
                hi = mid-1;
            }
        }
        return result;
    }

    private Boolean canMakeValidSubstring(
            String s,
            int substringLength,
            int k) {

        int[] freqMap = new int[26];
        int maxFrequency = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end += 1) 
        {
            freqMap[s.charAt(end) - 'A'] += 1;

            if (end-start+1 > substringLength) 
            {
                freqMap[s.charAt(start) - 'A'] -= 1;
                start += 1;
            }

            maxFrequency = Math.max(maxFrequency, freqMap[s.charAt(end) - 'A']);
            if (substringLength - maxFrequency <= k) 
            {
                return true;
            }
        }
        return false;
    }
}