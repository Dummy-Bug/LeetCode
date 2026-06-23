class Solution {
    public boolean canChange(String start, String target) {
        
        int n = start.length();
        
        int rCount = 0;
        int lCount = 0;
        int trCount = 0;
        int tlCount = 0;

        int j = 0;

        for (int i = 0; i < n; i++){

            char targetChar = target.charAt(i);

            if (targetChar == 'L'){

                tlCount++;

                while (j < n){

                    char startChar = start.charAt(j);

                    if (startChar == 'R') return false;

                    if (startChar == 'L'){
                        lCount++;
                        if (j < i) return false;
                        break;
                    }
                    j++;
                }
                if (j >= n) return false;
                j++;

            }
            else if (targetChar == 'R'){

                trCount++;

                while (j < n){

                    char startChar = start.charAt(j);

                    if (startChar == 'L') return false;

                    if (startChar == 'R'){
                        rCount++;
                        if (j > i) return false;
                        break;
                    }
                    j++;
                }
                if (j >= n) return false;
                j++;
            }
        }
        while (j < n){
            System.out.println(j);
            if (start.charAt(j) != '_') return false;
            j++;
        }
        return ((lCount == tlCount ) && (rCount == trCount));
    }
}