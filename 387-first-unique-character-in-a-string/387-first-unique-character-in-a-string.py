class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        freq_array  = [0]*26;
        index_array = [0]*26;
        
        for i in range(len(s)):
            
            char = s[i];
            
            freq_array[ord(char)-97] += 1;
            index_array[ord(char)-97] = i;
            
        
        for i in range(len(s)):
            
            char = s[i];
            
            if freq_array[ord(char)-97] == 1:
                return index_array[ord(char)-97];
        return -1;
            
        