import java.util.*;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {

                // If stack is empty, no matching opening bracket
                if (st.isEmpty()) return false;

                char top = st.peek();

                // Check for matching pair
                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    st.pop();
                } else {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched
        return st.isEmpty();
    }
}