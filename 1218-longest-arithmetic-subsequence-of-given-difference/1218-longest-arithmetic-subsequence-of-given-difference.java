class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        Map<Integer,Integer> map = new HashMap<>();

        int maxCount = 0;

        for (int num : arr) {

            int length = map.getOrDefault(num - difference,0);
            length = length + 1;
            map.put(num,length);

            maxCount = Math.max(maxCount , length);
        }

        return maxCount;
    }
}