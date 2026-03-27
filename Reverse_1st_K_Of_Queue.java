import java.util.*;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * Uses a stack to reverse the first k elements
 * and then appends the remaining elements in order.
 */
class Solution {

    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        // Edge case: if k is greater than queue size
        if (k > q.size()) return q;

        Stack<Integer> s = new Stack<>();

        // Step 1: Push first k elements into stack
        int i = 0;
        while (!q.isEmpty() && i < k) {
            s.push(q.poll());
            i++;
        }

        // New queue to store result
        Queue<Integer> q1 = new LinkedList<>();

        // Step 2: Pop from stack (reversed order)
        while (!s.isEmpty()) {
            q1.add(s.pop());
        }

        // Step 3: Add remaining elements
        while (!q.isEmpty()) {
            q1.add(q.poll());
        }

        return q1;
    }
}