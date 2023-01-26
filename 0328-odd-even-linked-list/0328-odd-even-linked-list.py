class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head;
        i = 1;
        curr = head;
        dummy = ListNode();
        odd = even = None; even_link = head.next;
        
        while curr:
            
            if (i&1) == 1:
                if odd:
                    odd.next = curr;
                odd = curr;
            else:
                if even:
                    even.next = curr;
                even = curr;
            curr = curr.next;
            i += 1;
        odd.next  = even_link;
        even.next = None;
        
        return head;
            
            
                
                
        