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
     * Space Complexity: O(n / k)  (recursive stack)
     *
     * Reverses nodes in groups of size k using recursion.
     * If remaining nodes are less than k, they are left unchanged.
     */

    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode temp = head;

        // Step 1: Check if there are at least k nodes
        while (count < k) {
            if (temp == null) return head; // not enough nodes
            temp = temp.next;
            count++;
        }

        // Step 2: Recursively reverse remaining list
        ListNode prevNode = reverseKGroup(temp, k);

        // Step 3: Reverse current group of k nodes
        temp = head;
        count = 0;

        while (count < k) {
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            count++;
        }

        // New head of this segment
        return prevNode;
    }
}