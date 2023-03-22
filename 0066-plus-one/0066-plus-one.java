class Solution {
    public void swap(int[] digits,int i, int j){
        int temp  = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
    public void reverse(int[] digits){
        int i;
        int j = digits.length-1;
        
        for(i=0;i<=j;i++,j--){
            swap(digits,i,j);
        }
        
    }
    public int[] plusOne(int[] digits) {
        
        reverse(digits); 
        int carry = 1;
        for(int i = 0;i<digits.length;i++){
            if (carry == 0){
                reverse(digits);
                return digits;
            }
            int curr_num = digits[i]+carry;
            
            if (curr_num>9){
                digits[i] = 0;
                carry = 1;
            }
            else{
                digits[i] = curr_num;
                carry = 0;
            }
        }
        if (carry==1){
            int[] result = new int[digits.length+1];
            reverse(digits);
            int i ;
            for (i =0; i<digits.length;i++){
                result[i] = digits[i];
            }
            result[i] = 1;
            reverse(result);
            return result;
        }
        else{
            reverse(digits);
            return digits;
        }
    }
}