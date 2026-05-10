class Solution {

    public long minArraySum(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        long sum = 0l;
        
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < n; i++){

            int num = nums[i];
            int limit = (int)(Math.pow(num,0.5) + 1);

            TreeSet<Integer> ts = new TreeSet<>();

            for (int f = 1; f <= limit; f++){
                if (num%f == 0){
                    ts.add(f);
                    ts.add(num / f);
                }
            }
            int minFactor = num;

            for (int factor : ts){
                if (set.contains(factor)){
                    minFactor = factor;
                    break;
                }
            }
            sum += minFactor;
        }
        return sum;
    }
}