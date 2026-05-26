class Solution {

    private int getDigit(int n,int i){
        n = n/(int)Math.pow(10,i);
        return n%10;
    }
    public long sumDigitDifferences(int[] nums) {
        
        Map<Integer,Long> freq = new HashMap<>();
        int n = nums.length;

        int digitCount = Integer.toString(nums[0]).length();
        long ans = 0;

        while(digitCount != 0){
            
            digitCount--;
            
            for (int i = 0; i < n; i++){

                int digit = getDigit(nums[i],digitCount);
                
                long count = freq.getOrDefault(digit , 0L);
                long difference = (i + 1) - (count + 1);
                ans = ans + difference;
                freq.put(digit, count + 1);
            }
            freq.clear();
        }
        return ans;
    }
}