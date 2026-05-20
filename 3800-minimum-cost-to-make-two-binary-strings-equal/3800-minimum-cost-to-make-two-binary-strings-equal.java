class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        

        int n = s.length();

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++){

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (ch1 == ch2){
                continue;
            }
            else if (ch1 == '1'){
                count1++;
            }else{
                count2++;
            }
        }

        long maxCount = Math.max(count1,count2);
        long minCount = Math.min(count1,count2);

        if (minCount == maxCount){

            long c1 = minCount*swapCost;
            long c2 = (minCount + maxCount)*flipCost;

            return Math.min(c1,c2);
        }

        long c2 = (minCount + maxCount)*flipCost;

        long numberOfCross = (maxCount - minCount)/2;
        long numberOfSwaps = (maxCount + minCount)/2;
        long numFlips = 0;

        if ( (maxCount&1) != 0 && (minCount&1) == 0) {
            numFlips = 1;
        }else if( (maxCount&1) == 0 && (minCount&1) != 0){
            numFlips = 1;
        }

        long c3 = numberOfCross*crossCost + numberOfSwaps*swapCost + numFlips*flipCost;

        long c4 = minCount*swapCost + (maxCount - minCount)*flipCost;

        return Math.min(Math.min(c2,c3),c4);
       
    }
}