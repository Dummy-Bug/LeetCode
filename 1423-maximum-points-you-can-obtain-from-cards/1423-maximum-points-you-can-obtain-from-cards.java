class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;

        int i = n - k ;
        int j = i;

        int maxPoints = 0;
        int currPoints = 0;

        while ( i <= n){

            if (j - i + 1 < k){
                currPoints += cardPoints[j];
                j++;
                continue;
            }

            currPoints += cardPoints[j%n];
            maxPoints = Math.max(currPoints,maxPoints);
            currPoints -= cardPoints[i%n];

            i++;
            j++;

        }
        return maxPoints;
    }
}