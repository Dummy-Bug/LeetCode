class Solution:
    def kClosest(self, nums: List[List[int]], k: int) -> List[List[int]]:
        
        self.k = k-1;
        return self.helper(nums,0,len(nums)-1);
        
    
    def helper(self,nums,start,end):
        
        while start <= end:
            pivot_index=random.randint(start,end);
            pivot_index=self.partition(nums,start,end,pivot_index)
            # pivot_index = self.partition(nums,start,end);
            # print(pivot_index)
            if pivot_index == self.k:
                return nums[:pivot_index+1];
            
            elif pivot_index > self.k:
                return self.helper(nums,start,pivot_index-1);
            else:
                return self.helper(nums,pivot_index+1,end);
    
    def partition(self,points,start,end,pivot_index):
        
        points[start],points[pivot_index]=points[pivot_index],points[start];
        pivot = start; left = start+1;right = end;
        
        while left<=right:
            
            if points[left][0]**2+points[left][1]**2 <= points[pivot][0]**2+points[pivot][1]**2:
                left += 1;
            elif points[right][0]**2+points[right][1]**2 > points[pivot][0]**2+points[pivot][1]**2:
                right -= 1;
            else:
                points[left],points[right] = points[right],points[left];
                left += 1;
                right -= 1;
        points[left-1],points[pivot] = points[pivot],points[left-1];
        
        return left-1;
                
            
            
        