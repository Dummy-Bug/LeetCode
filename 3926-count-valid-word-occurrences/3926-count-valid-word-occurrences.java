class Solution {

    private boolean checkInvalid(String s,int index){
        
        char ch = s.charAt(index); 

        if (ch != ' ' && ch != '-') return false;

        int n = s.length();
        if (ch == ' ') return true;
        
        if (index ==  n-1 && ch == '-') return true;
        if (index == 0 && ch == '-') return true;

        char prevChar = s.charAt(index-1);
        char nextChar = s.charAt(index+1);

        if ((ch == '-') && (nextChar == ' ' || nextChar == '-' || prevChar == ' ' || prevChar == '-')){
            return true;
        }
        return false;
    }
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        
        String joined = String.join("",chunks);

        int i = 0; int j = 0;
        int n = joined.length();

        List<String> al = new ArrayList<>();

        while(j < n){

            boolean isInvalid = checkInvalid(joined,j);

            if (isInvalid){
                if (i < j){
                    al.add(joined.substring(i,j));
                }
                j++;
                i = j;
            }
            
            else {
                if (j == n-1){
                    al.add(joined.substring(i,j+1));
                }
                j++;
            }
        }
        
        Map<String,Integer> map = new HashMap<>();

        for (int x = 0; x < al.size(); x++){
            String word = al.get(x);
            map.put(word,map.getOrDefault(word,0)+1);
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int y = 0; y < m; y++){
            String word = queries[y];
            ans[y] = map.getOrDefault(word,0);
        }
        return ans;
    }
}