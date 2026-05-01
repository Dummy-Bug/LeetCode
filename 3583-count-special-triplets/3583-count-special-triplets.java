class Solution {
    public int specialTriplets(int[] nums) {

        int n = nums.length;
        
        int [] left = new int[n];
        int [] right = new int[n];

        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        
        for (int i = 1; i < n; i++){
            int count = map.getOrDefault(2*nums[i],0);
            left[i] = count;
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.clear();
        map.put(nums[n-1],1);

        for (int i = n-2; i >= 0; i--){
            int count = map.getOrDefault(2*nums[i],0);
            right[i] = count;
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.clear();

        int total = 0; int leftCount = 0; int rightCount = 0;
        int MOD = 1000000000 + 7;
        for (int i = 1; i < n-1; i++){

            leftCount = left[i];
            rightCount = right[i];

            long current = ((long)leftCount * rightCount)%MOD;
            total = (int)(total + current)%MOD;
        }
        return total;

    }
}