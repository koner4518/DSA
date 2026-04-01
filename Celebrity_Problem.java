import java.util.*;

/*
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)  (stack)
 *
 * Uses stack to eliminate non-celebrities.
 * A celebrity:
 *   - Knows nobody
 *   - Is known by everyone
 */
class Solution {
    public int celebrity(int mat[][]) {

        Stack<Integer> s = new Stack<>();

        // Step 1: Push all people into stack
        for (int i = 0; i < mat.length; i++) {
            s.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (s.size() > 1) {

            int i = s.pop();
            int j = s.pop();

            // If i knows j → i cannot be celebrity
            // Else j cannot be celebrity
            if (mat[i][j] == 0) {
                s.push(i);
            } else {
                s.push(j);
            }
        }

        // No candidate
        if (s.isEmpty()) return -1;

        int cel = s.peek();

        // Step 3: Verify candidate
        for (int i = 0; i < mat.length; i++) {

            if (i != cel) {

                // Celebrity should not know anyone
                // Everyone should know celebrity
                if (mat[i][cel] == 0 || mat[cel][i] == 1) {
                    return -1;
                }
            }
        }

        return cel;
    }
}