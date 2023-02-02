class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        # Kth largest element is equivalent to (n-k+1)th smallest element
        
        import heapq
        pq = []
        
        for num in nums:
            heapq.heappush(pq,num) # will contain minimum element at the top
            
            if len(pq) > k: # if we maintain minHeap of size k 
                heapq.heappop(pq)# then top of minHeap will contain kth
                                 # largest number 
        
        return heapq.heappop(pq)