class Solution {

    private int reverse(int n){

        int reverse = 0;

        while(n != 0){
            int r = n%10;
            reverse = reverse*10 + r;
            n = n/10;
        }
        return reverse;
    }
    public int minMirrorPairDistance(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        int minDifference = Integer.MAX_VALUE;

        for (int i = n-1; i >= 0; i--){

            int num = nums[i];
            int reverseNum = reverse(num);

            if (map.containsKey(reverseNum)){
                int difference = map.get(reverseNum) - i;
                minDifference = Math.min(difference,minDifference);
            }
            map.put(num,i);
        }
        if (minDifference == Integer.MAX_VALUE){
            return -1;
        }
        return minDifference;
    }
}