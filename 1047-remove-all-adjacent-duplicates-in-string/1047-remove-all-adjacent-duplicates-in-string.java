class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()){
            
            int n = sb.length();

            if (n == 0 || sb.charAt(n - 1) != ch){
                sb.append(ch);
            }
            else {
                sb.deleteCharAt(n - 1);
            } 
        }
        return sb.toString();
    }
}