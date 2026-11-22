class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        int ans = 1;
        int n = nums.length;
        int left = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++){

            int freq = 1 + map.getOrDefault(nums[right] , 0);
            map.put(nums[right] , freq);

            if (freq <= k){
                ans = Math.max(ans , right - left + 1);
                continue;
            }
            while(nums[left] != nums[right]){
                map.put(nums[left] , map.get(nums[left]) - 1);
                left++;
            }
            map.put(nums[left] , map.get(nums[left]) - 1);
            left++;
        }
        return ans;
    }
}