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
     * Steps:
     * 1. Find length of list
     * 2. Normalize k using k % size
     * 3. Find new tail (size - k - 1)
     * 4. Break and reconnect list
     */

    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null) return head;

        // Step 1: Find size of linked list
        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Step 2: Normalize k
        k = k % size;
        if (k == 0) return head;

        // Step 3: Find new tail (size - k - 1)
        temp = head;
        for (int i = 0; i < size - k - 1; i++) {
            temp = temp.next;
        }

        // Step 4: Break and reconnect
        ListNode newHead = temp.next;
        temp.next = null;

        // Go to end of new list
        ListNode curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Connect last node to original head
        curr.next = head;

        return newHead;
    }
}