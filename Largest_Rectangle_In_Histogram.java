import java.util.*;

/*
 * Time Complexity: O(n)
 *   - Each element is pushed and popped at most once
 *
 * Space Complexity: O(n)
 *   - For stack + NSL and NSR arrays
 *
 * Uses Monotonic Stack to find:
 * - Next Smaller to Left (NSL)
 * - Next Smaller to Right (NSR)
 * Then computes max area for each bar.
 */
class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nsl = nextSmallerLeft(heights);
        int[] nsr = nextSmallerRight(heights);

        int maxArea = 0;

        // Calculate area for each bar
        for (int i = 0; i < n; i++) {

            // Width = nsr - nsl - 1
            int width = nsr[i] - nsl[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Next Smaller to Left (index)
    public int[] nextSmallerLeft(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            // Maintain increasing stack
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // If no smaller element on left
            if (s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            }

            s.push(i);
        }

        return res;
    }

    // Next Smaller to Right (index)
    public int[] nextSmallerRight(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // Maintain increasing stack
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // If no smaller element on right
            if (s.isEmpty()) {
                res[i] = arr.length;
            } else {
                res[i] = s.peek();
            }

            s.push(i);
        }

        return res;
    }
}