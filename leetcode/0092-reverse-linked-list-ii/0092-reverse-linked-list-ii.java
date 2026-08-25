
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       
       
       ListNode dummy = new ListNode(0);
        dummy.next = head;
       
       
        ListNode before=dummy;
        int position =1;
        if(head==null){
            return null;
        }
        if(left==right){
            return head;
        }
        while (position < left) {
            before = before.next;
            position++;
        }

            ListNode current=before.next;
            ListNode prev=null;
            int times=right-left+1;
            
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        before.next.next = current;
        before.next = prev;

        return dummy.next;
    }
}