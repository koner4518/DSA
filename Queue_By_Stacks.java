import java.util.*;

/*
 * Time Complexity:
 *   push()  -> O(n)
 *   pop()   -> O(1)
 *   peek()  -> O(1)
 *   empty() -> O(1)
 *
 * Space Complexity: O(n)
 *
 * Uses two stacks to simulate queue behavior (FIFO).
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {

        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push new element into s1
        s1.push(x);

        // Move everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {

        // Remove front element
        if (s1.isEmpty()) return -1;
        return s1.pop();
    }

    public int peek() {

        // Get front element
        if (s1.isEmpty()) return -1;
        return s1.peek();
    }

    public boolean empty() {

        // Queue is empty if s1 is empty
        return s1.isEmpty();
    }
}