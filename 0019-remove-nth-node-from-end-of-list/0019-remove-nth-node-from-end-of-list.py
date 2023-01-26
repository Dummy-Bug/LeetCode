class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        fast = slow = head;
        
        for _ in range(n):
            fast = fast.next;

        prev = None;
        while fast:
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        if not prev:
            return head.next;
        prev.next = prev.next.next;
        
        return head;
            
            
            