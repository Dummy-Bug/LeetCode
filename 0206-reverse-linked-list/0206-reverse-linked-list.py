class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        Prev = Next =None;
        curr = head;
        
        while curr:
            Next = curr.next;
            curr.next = Prev;
            Prev = curr;
            curr = Next;
        return Prev;
        