class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int maxLength = 0;

        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();

        for (int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if (nums[j]%2 == 0 && !evenSet.contains(nums[j]) ){
                    evenSet.add(nums[j]);
                }
                else if (nums[j]%2 != 0 && !oddSet.contains(nums[j]) ){
                    oddSet.add(nums[j]);
                }

                if (evenSet.size() == oddSet.size()){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
            evenSet.clear();
            oddSet.clear();
        }
        return maxLength;
    }
}