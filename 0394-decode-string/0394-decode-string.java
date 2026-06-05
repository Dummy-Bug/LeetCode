class Solution {

    class Tuple {

        int count;
        String s;

        Tuple(int freq, String string){
            count = freq;
            s = string;
        }
    }

    public String decodeString(String s) {
        
        Deque<Tuple> stack = new ArrayDeque<>();

        int num = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()){

            if (Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            else if (ch == '['){
                stack.push(new Tuple(num , sb.toString()));
                sb = new StringBuilder();
                num = 0;
            }
            else if (ch == ']'){
                
                Tuple top = stack.pop();
                StringBuilder sb1 = new StringBuilder(sb);

                for (int i = 1; i < top.count; i++){
                    // System.out.println(i+" "+sb.toString());
                    sb.append(sb1);
                }

                sb.insert(0, top.s); 

            }else{
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}