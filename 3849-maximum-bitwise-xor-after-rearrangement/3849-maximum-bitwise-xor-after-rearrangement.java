class Solution {
    public String maximumXor(String s, String t) {
       
       Map<Character,Integer> map = new HashMap<>();
       int n = t.length();

       for (int i = 0; i < n; i++){
        char ch = t.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
       } 

       StringBuilder sb = new StringBuilder();

       for (int i = 0; i < n; i++){
        
        char ch = s.charAt(i);
        if (ch == '1'){
            int count = map.getOrDefault('0',0);
            if (count != 0){
                sb.append('1');
                map.put('0',count-1);
            }else{
                sb.append('0');
            }
        } 
        else{
            int count = map.getOrDefault('1',0);
            if (count != 0){
                sb.append('1');
                map.put('1',count-1);
            }
            else{
                sb.append('0');
            }
        }
       }
       return sb.toString();
    }
}