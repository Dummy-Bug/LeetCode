class Solution:
    def kthSmallest(self, A: List[List[int]], B: int) -> int:
        heap = []; flag = False;
        heapq.heapify(heap);

        for i in range(len(A)):
            for j in range(len(A[0])):
                
                if len(heap)<B:
                    heapq.heappush(heap,-1*A[i][j]);

                elif -1*heap[0] > A[i][j]:
                    heapq.heappop(heap);
                    heapq.heappush(heap,-1*A[i][j]);

        return -1*heapq.heappop(heap);
                
        