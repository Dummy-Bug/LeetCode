class Solution:
    def closetTarget(self, words: List[str], target: str, startIndex: int) -> int:
        
        if target == words[startIndex]:
            return 0;
        
        n = len(words); shortest_dist = float('inf');
        
        left  = (startIndex-1+n)%n;
        right = (startIndex+1)%n;
        distance = 1;
        
        while distance<n:
            
            if words[left] == target or words[right] == target:
                return distance;
            distance += 1;
            left  = (left-1+n)%n;
            right = (right+1)%n
        
        return -1
            
        