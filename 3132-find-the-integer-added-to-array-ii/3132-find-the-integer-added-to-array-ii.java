class Solution {
    
    private boolean isValid(int ans , int i , int j, int [] nums1, int [] nums2){

        int skipped = 0;
        for (int k = 0; k < nums1.length; k++){
            if (k == i || k == j){
                skipped += 1;
                continue;
            }
            if ((nums1[k] + ans) != nums2[k - skipped]) return false;
        }
        return true;
    }


    public int minimumAddedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int totalSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            totalSum += nums1[i];
        }

        int expectedSum = 0;
        for (int i = 0; i < nums2.length; i++) {
            expectedSum += nums2[i];
        }

        int minX = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {

            for (int j = i + 1; j < nums1.length; j++) {
                int pairSum = nums1[i] + nums1[j];

                int effectiveSum = expectedSum - (totalSum - pairSum);

                int n = nums1.length - 2;

                if ((effectiveSum) % n != 0) {
                    continue;
                }

                int possibleAnswer = effectiveSum / n;
                if (isValid(possibleAnswer , i , j, nums1 , nums2)){
                    minX = Math.min(possibleAnswer, minX);
                }
            }   
        }
        return minX;
    }
}