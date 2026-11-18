class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        long min = 0l;
        long max = 0l;

        long prev = 0l;

        for (int d : differences){
            prev = d + prev;
            min = Math.min(min , prev);
            max = Math.max(max , prev);
        }

        long allowableMin = (long)lower - min;
        long allowableMax = (long)upper - max;

        if (allowableMax < allowableMin) return 0;

        return (int)(allowableMax - allowableMin + 1);

    }
}