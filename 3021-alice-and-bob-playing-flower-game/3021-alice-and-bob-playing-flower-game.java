class Solution {

    private long getPairs(int num , int x, int y){

        long totalPairs = num - 1;
        int min = Math.min(x,y);
        

        if (min >= totalPairs){
            return totalPairs;
        }
        long possiblePairs = min;

        int max = Math.max(x,y);
        if (totalPairs > max){
            return possiblePairs - (totalPairs - max);
        }
        return possiblePairs;
    }

    public long flowerGame(int n, int m) {

        int maxNumber = m + n;
        long pairs = 0;

        for (int num = 3; num <= maxNumber; num +=2){

            pairs += getPairs(num,n,m);
        }
        return pairs;
        
    }
}