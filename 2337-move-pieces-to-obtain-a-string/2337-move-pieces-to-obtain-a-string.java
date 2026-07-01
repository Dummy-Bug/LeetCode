class Solution {
    public boolean canChange(String start, String target) {
        
        int i = 0 , j = 0;
        int n = start.length();

        int c1 = 0 , c2 = 0;

        while ( i < n && j < n){

            char t = target.charAt(i);

            if (t == '_') c1++;

            else if (t == 'L'){

                while( j < n){

                    char s = start.charAt(j);

                    if (s == 'R') return false;

                    else if (s == 'L'){
                        if (i > j) return false;
                        j++;
                        break;
                    }

                    else c2++;
                    j++;
                }
                
            }
            else {
                while (j < n){

                    char s = start.charAt(j);

                    if (s == 'L') return false;
                    else if (s == 'R'){
                        if (i < j) return false;
                        j++;
                        break;
                    }
                    else c2++;
                    j++;
                }
            }
            i++;
        }
        while( i != n){
            char t = target.charAt(i);
            if (t != '_') return false;
            else c1++;
            i++;
        }
        while( j != n){
            char s = start.charAt(j);
            if (s != '_') return false;
            else c2++;
            j++;
        }
        return c1 == c2;
    }
}