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
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Rearranges the linked list such that all odd-indexed nodes come first followed by even-indexed nodes.
     * (Indexing is 1-based)
     */

    public ListNode oddEvenList(ListNode head) {

        // Edge cases
        if (head == null || head.next == null) return head;

        // Initialize odd and even pointers
        ListNode odd = head;
        ListNode even = head.next;

        // Store head of even list to connect later
        ListNode evenHead = even;

        // Rearrange nodes
        while (even != null && even.next != null) {

            // Link next odd node
            odd.next = even.next;
            odd = odd.next;

            // Link next even node
            even.next = even.next.next;
            even = even.next;
        }

        // Connect end of odd list to start of even list
        odd.next = evenHead;

        return head;
    }
}