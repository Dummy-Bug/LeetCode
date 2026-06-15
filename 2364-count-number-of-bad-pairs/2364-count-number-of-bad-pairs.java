class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long totalPairs = ((long)n*(n-1)) / 2;

        Map<Integer,Integer> map = new HashMap<>();
        long goodPairs = 0L;

        for (int i = 0; i < n; i++){
            int num = nums[i];

            int freq = map.getOrDefault(nums[i] - i , 0);
            map.put(nums[i] - i, freq + 1);
            goodPairs += freq;
        }

        return totalPairs - goodPairs;
    }
}