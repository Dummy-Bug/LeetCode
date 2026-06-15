class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int num : nums1){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int i = 0;
        for (int num : nums2){

            if (map.higherKey(num) == null){

                int smallest = map.firstKey();
                nums1[i] = smallest;
                
                int freq = map.get(smallest);
                if (freq == 1){
                    map.remove(smallest);
                }
                else map.put(smallest , freq - 1);
            }
            else{
                int higher = map.higherKey(num);
                nums1[i] = higher;

                int freq = map.get(higher);
                if (freq == 1){
                    map.remove(higher);
                }
                else map.put(higher , freq - 1);

            }
            i++;
        }
        return nums1;
    }
}