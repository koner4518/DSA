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
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n))
     * Iterates through both linked lists and simulates digit-by-digit addition with carry handling.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify result list construction
        ListNode dummy = new ListNode(-1);

        // Pointer to build the result list
        ListNode res = dummy;

        int total = 0;
        int carry = 0;

        // Traverse both lists until all nodes and carry are processed
        while (l1 != null || l2 != null || carry != 0) {

            total = carry;

            // Add value from l1 if present
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            // Add value from l2 if present
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            // Extract digit and update carry
            int num = total % 10;
            carry = total / 10;

            // Create new node with the computed digit
            dummy.next = new ListNode(num);

            // Move pointer forward
            dummy = dummy.next;
        }

        // Return head of the result list
        return res.next;
    }
}