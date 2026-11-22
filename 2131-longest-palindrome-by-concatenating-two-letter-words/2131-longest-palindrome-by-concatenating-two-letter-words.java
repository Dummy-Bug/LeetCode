class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String,Integer> map = new HashMap<>();

        for (String word : words){
            map.put(word , 1 + map.getOrDefault(word , 0));
        }

        int ans = 0;
        boolean isExtra = false;
        Set<String> set = new HashSet<>();

        for (String word : words){

            if (set.contains(word)){
                continue;
            }

            int c1 = map.get(word);

            String palindrome = String.valueOf(word.charAt(1)) + String.valueOf(word.charAt(0) );
            
            if (word.charAt(1) == word.charAt(0)){
                if (c1 %2 != 0){
                    isExtra = true;
                }
                ans = ans + 4*(c1/2) ;
                set.add(word);
                continue;
            }

            
            int c2 = map.getOrDefault(palindrome , 0);
            ans = ans + 4*Math.min(c1,c2);
            System.out.println(word + " " + palindrome + " " + c1 + " " + c2);
            set.add(word);
            set.add(palindrome);
        }
        if (isExtra){
            ans += 2;
        }
        return ans;
    }
}