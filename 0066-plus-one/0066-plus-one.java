class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> ans = new ArrayList<>();
        int carry = 1;
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--){

            int num = digits[i];
            int result = (num + carry)%10;
            carry = (num + carry)/10;
                        
            ans.add(result);
        }
        if (carry == 1){
            ans.add(1);
        }

        int sz = ans.size();
        int [] result = new int[sz];

        for (int i = sz - 1; i >= 0; i--){
            result[sz - i - 1] = ans.get(i);
        }
        return result;

    }
}