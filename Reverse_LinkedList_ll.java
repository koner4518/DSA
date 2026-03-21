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
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Edge case
        if (head == null || head.next == null) return head;

        // Dummy node to handle edge cases like reversing from head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move prev to node just before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr points to the first node of sublist
        ListNode curr = prev.next;

        // Step 2: Reverse sublist using head insertion
        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            // Remove 'next' and insert it after 'prev'
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}