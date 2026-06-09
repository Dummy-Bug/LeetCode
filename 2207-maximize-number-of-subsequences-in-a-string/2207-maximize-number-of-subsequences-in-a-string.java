class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        long p1Count = 0L;
        long p2Count = 0L;

        long addedP1 = 0L;
        long skippedP1 = 0L;
        
        for(char c : text.toCharArray()){

            if (c == pattern.charAt(0)){
                p1Count++;
                p2Count++;
            }
            else if ( c == pattern.charAt(1)){
                skippedP1 += p1Count ;
                addedP1 += p1Count + 1;
            }
        }

        if (pattern.charAt(1) == pattern.charAt(0)){
            return ( (p1Count + 1) * (p1Count) ) / 2;
        }

        skippedP1 += p1Count;

        return Math.max(addedP1 , skippedP1);

    }
}