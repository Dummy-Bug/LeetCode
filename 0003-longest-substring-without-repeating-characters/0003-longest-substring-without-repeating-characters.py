class Solution:

    def lengthOfLongestSubstring(self, string):
        
        freq_map = dict();
        
        for character in string:
            if character not in freq_map:
                freq_map[character] = 0;
        
        i = j = 0; 
        max_length = 0;
        
        while j<len(string):
            
            
            if freq_map[string[j]] == 0:
                max_length = max(max_length,j-i+1);
                freq_map[string[j]] += 1;
                j += 1;
                continue;
                
            while freq_map[string[j]] != 0:
                freq_map[string[i]] -= 1;
                i += 1;
 
        
        return max_length
