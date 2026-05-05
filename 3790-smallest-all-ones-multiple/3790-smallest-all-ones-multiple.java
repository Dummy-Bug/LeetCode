class Solution {
    public int minAllOneMultiple(int k) {

        Set<Integer> set = new HashSet<>();
        
        int num = 1;
        int totalDigits = 0;

        while(true){

            int mod = num%k;
            if (mod == 0) return totalDigits + 1;
            
            if (set.contains(mod)) return -1;
            set.add(mod);

            num = num*10 + 1;
            totalDigits += 1;
        }
    }
}