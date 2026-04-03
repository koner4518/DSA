import java.util.*;

/*
 * Time Complexity: O(n^2)
 *   - For each element, we may traverse the stack
 *
 * Space Complexity: O(n)
 *   - Recursive call stack
 *
 * Sorts stack using recursion (no extra data structures).
 * Uses helper function to insert elements in sorted order.
 */
class Solution {
    public void sortStack(Stack<Integer> st) {

        // Base case
        if (st.isEmpty()) return;

        // Step 1: Remove top element
        int top = st.pop();

        // Step 2: Sort remaining stack
        sortStack(st);

        // Step 3: Insert element in sorted position
        insertSorted(st, top);
    }
    
    private void insertSorted(Stack<Integer> s, int x) {

        // If stack is empty OR correct position found
        if (s.isEmpty() || s.peek() <= x) {
            s.push(x);
            return;
        }
        
        // Remove top and recurse
        int top = s.pop();

        insertSorted(s, x);

        // Put back removed element
        s.push(top);
    }
}