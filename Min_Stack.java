import java.util.*;

/*
 * Time Complexity:
 *   push()   -> O(1)
 *   pop()    -> O(1)
 *   top()    -> O(1)
 *   getMin() -> O(1)
 *
 * Space Complexity: O(n)
 *
 * Uses a single stack with encoding to store previous minimums.
 * Trick: store modified values when a new minimum is encountered.
 */
class MinStack {
    Stack<Long> s;
    long minVal;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {

        long v = val;

        // First element
        if (s.isEmpty()) {
            s.push(v);
            minVal = v;
            return;
        }

        // If new value is smaller than current min
        if (v < minVal) {

            // Push encoded value
            // Formula: 2*v - minVal
            s.push(2 * v - minVal);

            // Update min
            minVal = v;

        } else {
            s.push(v);
        }
    }
    
    public void pop() {

        if (s.isEmpty()) return;

        long top = s.peek();

        // If encoded value found
        if (top < minVal) {

            // Recover previous min
            // Formula: prevMin = 2*minVal - encodedValue
            minVal = 2 * minVal - top;
        }

        s.pop();
    }
    
    public int top() {

        long top = s.peek();

        // If encoded value, actual top is minVal
        if (top < minVal) return (int) minVal;

        return (int) top;
    }
    
    public int getMin() {

        return (int) minVal;
    }
}