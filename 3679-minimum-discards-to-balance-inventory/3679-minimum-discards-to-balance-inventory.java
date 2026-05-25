class Solution {
    public int minArrivalsToDiscard(int[]  nums, int w, int m) {
        
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int n = nums.length;

        int i = 0;
        for (int j = 0; j < n ; j++){

            int count = map.getOrDefault(nums[j] , 0);

            if ( count + 1 > m ) {
                set.add(j);
            }else {
                map.put(nums[j], count + 1);
            }

            if (j - i + 1 == w){
                if (!set.contains(i)){
                    map.put(nums[i] , map.get(nums[i]) - 1);
                }
                i++;
            }
        }
        return set.size();
    }
}