import java.util.*;
/*
 * Time Complexity:
 *   push()  -> O(n)
 *   pop()   -> O(1)
 *   top()   -> O(1)
 *   empty() -> O(1)
 *
 * Space Complexity: O(n)
 * Uses two queues to simulate stack behavior (LIFO).
 */

class MyStack {


    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Add new element to q1
        q1.add(x);

        // Move all elements back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    public int pop() {

        // Remove top element
        if (q1.isEmpty()) return -1;
        return q1.poll();
    }

    public int top() {

        // Peek top element
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }

    public boolean empty() {

        // Stack is empty if q1 is empty
        return q1.isEmpty();
    }
}