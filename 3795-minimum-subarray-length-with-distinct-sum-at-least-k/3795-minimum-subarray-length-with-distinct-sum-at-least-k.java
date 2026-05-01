class Solution {
    public int minLength(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;

        while (j < n) {
            
            int freq = map.getOrDefault(nums[j], 0);
            
            if (freq == 0) {
                sum += nums[j];
            }
            map.put(nums[j],freq+1);

            while(sum >= k && i <= j){
                
                minLength = Math.min(minLength,j-i+1);
                
                freq = map.get(nums[i]);
                if (freq == 1){
                    sum -= nums[i];
                }
                map.put(nums[i],freq-1);
                i++;
            }
            j++;
        }

        if (minLength == Integer.MAX_VALUE) return -1;
        return minLength;
    }
}