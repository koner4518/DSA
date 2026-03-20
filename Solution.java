/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    /*
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA, tempB = headB;

        int sizeA = 0, sizeB = 0;

        // Step 1: Calculate lengths
        while (tempA != null) {
            tempA = tempA.next;
            sizeA++;
        }

        while (tempB != null) {
            tempB = tempB.next;
            sizeB++;
        }

        // Reset pointers to heads
        tempA = headA;
        tempB = headB;

        // Step 2: Align both pointers
        int steps = Math.abs(sizeA - sizeB);

        if (sizeA > sizeB) {
            for (int i = 0; i < steps; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 0; i < steps; i++) {
                tempB = tempB.next;
            }
        }

        // Step 3: Traverse together
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        // Either intersection node or null
        return tempA;
    }
}