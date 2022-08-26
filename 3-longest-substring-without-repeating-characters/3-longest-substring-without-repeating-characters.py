class Solution:

    def lengthOfLongestSubstring(self, string):
        
        freq_map = dict();
        
        for character in string:
            if character not in freq_map:
                freq_map[character] = 0;
        
        i = j = 0; 
        unique_char_count = max_length = 0;
        
        while j<len(string):
            
            if freq_map[string[j]] == 0:
                unique_char_count += 1;
                freq_map[string[j]] += 1;
                j += 1;
                continue;
            # freq_map[string[j]] += 1;
            max_length = max(max_length,unique_char_count);
            
            while freq_map[string[j]] != 0:
                freq_map[string[i]] -= 1;
                unique_char_count -= 1; # bcz every char inside window would have freq=1;
                i += 1;
        max_length = max(max_length,unique_char_count);
        
        return max_length;