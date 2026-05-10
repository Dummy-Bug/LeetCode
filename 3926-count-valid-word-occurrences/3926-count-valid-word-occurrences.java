class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        
        String joined = String.join("",chunks);
        System.out.println(joined);

        int i = 0; int j = 0;
        int n = joined.length();

        List<String> sb = new ArrayList<>();

        while(j < n){
    
            char ch = joined.charAt(j);

            if (ch == '-'){
                if (j == 0){
                    j++;
                    i++;
                    continue;
                }
                if (i == j){
                    i++;
                    j++;
                    continue;
                }
                if (j == n-1){
                    if (i<j){
                        sb.add(joined.substring(i,j));
                    }

                    j++;
                    i = j;
                    continue;
                }
                char prevChar = joined.charAt(j-1);
                char nextChar = joined.charAt(j+1);

                if (prevChar == ' ' || nextChar == ' ' || prevChar == '-' || nextChar == '-'){
                    sb.add(joined.substring(i,j));
                    j++;
                    i = j;
                }else{
                    j++;
                }
            }
            else if (ch == ' '){
                if (i == j){
                    i++;
                    j++;
                    continue;
                }
                sb.add(joined.substring(i,j));
                j++;
                i = j;
            }
            else {
                if (j == n-1){
                    sb.add(joined.substring(i,j+1));
                }
                j++;
            }
        }
        
        Map<String,Integer> map = new HashMap<>();

        for (int x = 0; x < sb.size(); x++){
            String word = sb.get(x);
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