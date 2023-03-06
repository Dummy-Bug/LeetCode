class Solution {
    public void helper(char[] char_arr,int p1,int p2){
        char temp = ' ';
        temp = char_arr[p1];
        char_arr[p1] = char_arr[p2];
        char_arr[p2] = temp;
    }
    public void reverseString(char[] s) {
        int p1 = 0,p2 = s.length-1;
        while (p1<p2){
            helper(s,p1,p2);
            p1 += 1;
            p2 -= 1;
        }
    }
}