/*
 * Time Complexity: O(n log n)
 *   - Sorting: O(n log n)
 *   - Binary search with feasibility check: O(n log(maxDistance))
 *
 * Space Complexity: O(1)  (ignoring sorting recursion stack)
 *
 * Uses Binary Search on Answer to find the maximum minimum distance between any two cows.
 */
import java.util.Arrays;

public class Aggressive_Cows {
    public static int aggressive_cows(int[] arr, int c) {

        // Sort stall positions
        Arrays.sort(arr);

        int start = 0;
        int end = arr[arr.length - 1];   // maximum possible distance
        int ans = -1;

        // Binary search on the minimum allowed distance
        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Check if we can place all cows with at least 'mid' distance
            if (isPossible(arr, c, mid)) {
                ans = mid;          // mid is possible, try for a larger distance
                start = mid + 1;
            } else {
                end = mid - 1;      // mid is not possible, try smaller distance
            }
        }

        return ans;
    }

    // Checks whether it is possible to place 'c' cows
    // such that the minimum distance between any two cows
    // is at least minAllowedDist
    public static boolean isPossible(int[] arr, int c, int minAllowedDist) {

        // Place the first cow in the first stall
        int cows = 1;
        int lastStallPos = arr[0];

        // Try to place remaining cows greedily
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - lastStallPos >= minAllowedDist) {
                cows++;
                lastStallPos = arr[i];
            }

            // All cows have been placed
            if (cows == c) return true;
        }

        return false;
    }
}