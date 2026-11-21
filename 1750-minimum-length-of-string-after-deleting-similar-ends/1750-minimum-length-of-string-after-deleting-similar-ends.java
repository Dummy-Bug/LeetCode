class Solution {
    public int minimumLength(String s) {
        
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (right > left){

            if (s.charAt(left) != s.charAt(right) || left == right) return right - left + 1;


            while((left + 1 < n) && (s.charAt(left) == s.charAt(left + 1))){
                left++;
            }

            while((right - 1 > 0 ) && (s.charAt(right) == s.charAt(right - 1))){
                right--;
            }
            left++;
            right--;
            
        }
        if (left > right) return 0;
        
        return right - left + 1;
    }
}