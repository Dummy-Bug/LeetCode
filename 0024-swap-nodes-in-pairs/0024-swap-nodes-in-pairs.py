class Solution:
    def swapPairs(self, head: Optional[ListNode]):
        
        if not head or not head.next:
            return head;
        
        temp = head.next;
        
        head.next = self.swapPairs(head.next.next);
        temp.next = head;
        
        return temp;
            
            
    