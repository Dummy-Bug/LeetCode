/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode reverse(ListNode head){
        ListNode next = head.next;
        ListNode prev = null;

        while(true){
            head.next = prev;
            prev = head;
            head = next;
            if (head == null){
                return prev;
            }
            next = next.next;
        }
 
    }

    private int [] reverse(int[] nums){

        int n = nums.length;

        int i = 0;
        int j = n - 1;

        while( i < j){
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        } 
        
        return nums;
    }
    public int[] nextLargerNodes(ListNode head) {
        
        head = reverse(head);
        
        ListNode temp = head;
        int n = 0;

        while(temp != null){
            temp = temp.next;
            n++;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int [] ans = new int[n];


        temp = head;
        int i = 0;

        while(temp != null){

            int val = temp.val;

            while (!stack.isEmpty() && stack.peek() <= val){
                stack.pop();
            }

            if (!stack.isEmpty()){
                ans[i] = stack.peek();
            }
            else{
                ans[i] = 0;
            }
            stack.push(val);
            i++;
            temp = temp.next;
        }
        return reverse(ans);
    }
}