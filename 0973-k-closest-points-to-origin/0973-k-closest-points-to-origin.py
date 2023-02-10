import heapq;

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        heap = []; k = k-1; result = [];
        
        for x,y in points:
            
            dist = (x**2+y**2)**0.5;
            
            if len(heap) <= k:
                heapq.heappush(heap,[-1*dist,[x,y]]);
                continue;
            if -1*heap[0][0] > dist:
                heapq.heappop(heap);
                heapq.heappush(heap,[-1*dist,[x,y]]);
            
        while len(heap) != 0:
            # print(heap)
            dist,points = heapq.heappop(heap);
            
            result.append(points);
        
        return result;
        
                
        
        
        