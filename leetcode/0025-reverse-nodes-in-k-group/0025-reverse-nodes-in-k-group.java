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
         void reverse(ListNode head, int times){
            ListNode curr=head;
            ListNode prev=null;
            while(times--> 0){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
         }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        
        ListNode left=head;
        ListNode res=null;
        ListNode prevleft=null;
        while(left!=null){
            ListNode right = left;
            for(int i=1;i<k;i++){
               if(right.next==null){
                prevleft.next = left;
                  return res;
                }
                right=right.next;
            }

            ListNode nextleft=right.next;
            reverse(left,k);

            if(prevleft!=null){
                prevleft.next=right;
            }
            if(res==null){
                res=right;
            }
             prevleft=left;
             left=nextleft;



        }
        return res;
    }
}