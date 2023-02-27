import heapq;

class MedianFinder:

    def __init__(self):
        self.min_heap = []; 
        self.max_heap = [];
        heapq.heapify(self.min_heap);
        heapq.heapify(self.max_heap);
    

    def addNum(self, num: int) -> None:
        if len(self.min_heap) == 0:
            heapq.heappush(self.min_heap,num);

        elif self.min_heap[0] <= num:
            heapq.heappush(self.min_heap,num);
        else:
            heapq.heappush(self.max_heap,-1*num);
        
        if len(self.min_heap)-len(self.max_heap) > 1:
            heapq.heappush(self.max_heap,-1*heapq.heappop(self.min_heap));
        
        elif len(self.max_heap)-len(self.min_heap) > 1:
            heapq.heappush(self.min_heap,-1*heapq.heappop(self.max_heap));
            
        

    def findMedian(self) -> float:
        # print(self.max_heap,self.min_heap);
        if ( len(self.max_heap) + len(self.min_heap) )%2 == 0:
            return ( -1*self.max_heap[0] + self.min_heap[0] )/2.0;
        
        elif len(self.max_heap)>len(self.min_heap):
            return -1*self.max_heap[0]*1.0;
        else:
            return self.min_heap[0]*1.0;
        
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()