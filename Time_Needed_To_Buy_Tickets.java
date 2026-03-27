import java.util.*;

/*
 * Time Complexity: O(n * max(tickets))
 * Space Complexity: O(n)
 *
 * Simulates the queue process:
 * - Each person buys one ticket at a time
 * - If tickets remain, they go back to the queue
 * - Stop when person k finishes
 */
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        // Store indices in queue
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        int time = 0;

        // Process queue
        while (!q.isEmpty()) {

            time++;

            int front = q.poll();

            // One ticket bought
            tickets[front]--;

            // If tickets still remaining, re-add to queue
            if (tickets[front] != 0) {
                q.add(front);
            } 
            // If this was person k and finished
            else if (front == k) {
                return time;
            }
        }

        return -1;
    }
}