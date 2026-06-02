class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {

        int count = helper(nums1,nums2) + helper(nums2,nums1);

        return count;
    }

    private int helper(int[] nums1, int[] nums2){

        Map<Long,Integer> map = new HashMap<>();

        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < n; i++){

            for (int j = i + 1; j < n; j++){

                long product = nums2[i] * (long)nums2[j];

                map.put(product , map.getOrDefault(product , 0) + 1);
            }
        }

        int count = 0;

        for (int num : nums1){

            long square = (long)num*num;
            count += map.getOrDefault(square , 0);
        }

        return count;

    }
}