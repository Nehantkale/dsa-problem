class Solution {

    void reverse(ListNode head, int times) {
        ListNode curr = head;
        ListNode prev = null;

        while (times-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode res = null;
        ListNode prevleft = null;

        while (left != null) {

            // Find the second node of the pair
            ListNode right = left.next;

            // If only one node is left, don't reverse it
            if (right == null) {
                if (prevleft != null) {
                    prevleft.next = left;
                }
                break;
            }

            // Save the node after this pair
            ListNode nextleft = right.next;

            // Reverse the pair
            reverse(left, 2);

            // After reversing:
            // right -> left
            // left is now the END of this pair

            // Connect previous pair to current pair
            if (prevleft != null) {
                prevleft.next = right;
            }

            // First reversed pair gives us the new head
            if (res == null) {
                res = right;
            }

            // left is the last node of current pair
            prevleft = left;

            // Move to next pair
            left = nextleft;
        }

        return res;
    }
}