class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        long ans = 0L;
        int xor = 0;

        for (int num : nums){
            xor = num ^ xor;
            int freq = map.getOrDefault(xor, 0);
            ans += freq;
            map.put(xor , freq + 1);
        }
        return ans;
    }
}