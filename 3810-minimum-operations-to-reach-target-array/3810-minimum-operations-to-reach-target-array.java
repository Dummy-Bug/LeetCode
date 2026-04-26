class Solution {
    public int minOperations(int[] nums, int[] target) {
        HashSet<Integer> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i< nums.length;i++){
            if(nums[i] != target[i]){
                if (!set.contains(nums[i])){
                    count++;
                    set.add(nums[i]);
                }
            }
        }
        return count;
    }
}