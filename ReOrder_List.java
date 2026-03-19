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
     * 1. Find middle of the list
     * 2. Reverse second half
     * 3. Merge both halves alternately
     */

    public void reorderList(ListNode head) {

        // Edge case: 0 or 1 node
        if (head == null || head.next == null) return;

        // Step 1: Find middle node
        ListNode mid = findMid(head);

        // Step 2: Reverse second half
        ListNode currNode = mid.next;
        ListNode prevNode = null;
        mid.next = null; // break the list

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        // Step 3: Merge two halves
        ListNode left = head;
        ListNode right = prevNode;

        while (left != null && right != null) {

            ListNode nextL = left.next;
            ListNode nextR = right.next;

            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    // Finds the middle node using slow-fast pointer
    public ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}