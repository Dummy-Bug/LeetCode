class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        
        int[] left = new int[n];
        Arrays.fill(left,Integer.MAX_VALUE);

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < 2*n; i++){
            
            int num = nums[i%n];
    
            if (map.containsKey(num)){

                int index = map.get(num);
                if (index%n == i%n){
                    left[i%n] = Integer.MAX_VALUE;
                }
                else{
                    int distance = i - map.get(num);
                    left[i%n] = Math.min(left[i%n],distance);
                }
            }
            map.put(num,i);
        }
        map.clear();

        int[] right = new int[n];
        Arrays.fill(right,Integer.MAX_VALUE);

        for (int i = 2*n-1; i >= 0; i--){

            int num = nums[i%n];

            if (map.containsKey(num)){
                
                int index = map.get(num);
                if (i%n == index%n){
                    right[i%n] = Integer.MAX_VALUE;
                }else {
                    int distance = map.get(num) - i;
                    right[i%n] = Math.min(right[i%n],distance);
                }
            }
            map.put(num,i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int index : queries){
            
            int min = Math.min(left[index],right[index]);

            if (min != Integer.MAX_VALUE){
                ans.add(min);
            }else {
                ans.add(-1);
            }
        }
        return ans;
    }
}