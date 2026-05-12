class Solution {
    public long sumDigitDifferences(int[] nums) {

        int maxDigits = 0;
        int digit = nums[0];

        while(digit != 0){
            maxDigits++;
            digit = digit/10;
        }

        int n = nums.length;
        long difference = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < maxDigits; i++){

            int divisor = (int)(Math.pow(10,i));

            for (int j = 0; j < n; j++){
                int num = nums[j];

                num = num/divisor;
                int rem = num%10;
                int count = map.getOrDefault(rem,0) + 1;
                map.put(rem,count);
                int totalValues = j + 1;
                difference += totalValues - count;
            }
            map.clear();
        }
        return difference;
    }
}