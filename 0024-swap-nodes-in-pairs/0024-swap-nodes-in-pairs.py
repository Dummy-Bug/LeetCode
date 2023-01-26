class Solution:
    def swapPairs(self, head: Optional[ListNode]):
        
        if not head or not head.next:
            return head;
        curr = head; dummy = ListNode();
        prev_link = dummy;

        while curr and curr.next:
            
            Next = curr.next;
            temp = Next.next;
            Next.next = curr;
            
            prev_link.next = Next;
            prev_link = curr;
            curr = temp;
        if not curr:
            prev_link.next = None;
        elif curr and not curr.next:
            prev_link.next = curr;
            curr.next = None
        return dummy.next
            
            
    