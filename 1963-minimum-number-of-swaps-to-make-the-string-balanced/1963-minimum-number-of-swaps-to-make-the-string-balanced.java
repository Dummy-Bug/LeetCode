class Solution {
    public int minSwaps(String s) {

        int count = 0;
        int open = 0;
        
        for (char ch: s.toCharArray()){

            if (ch == '['){
                open++;
            }
            else if (open == 0){
                count++;
            }
            else{
                open--;
            }
        }

        return (count+1)/2;
    }
}