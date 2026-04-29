class Solution {
    public int totalNumbers(int[] digits) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < digits.length; i++){
            if (digits[i] == 0){
                continue;
            }

            for(int j = 0; j < digits.length; j++){
                if (j == i){
                    continue;
                }

                for(int k = 0; k < digits.length; k++){
                    
                    if (k != i && k != j){
                        if (digits[k]%2 == 0){
                            set.add(100*digits[i] + 10*digits[j] + digits[k]);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}