/*
 * Time Complexity: O(n log S)
 *   where S = sum of all board lengths
 * Space Complexity: O(1)
 * Uses Binary Search on Answer to minimize the maximum time taken by any painter.
 */
public class Painter_Partition {
    public static int paintersPartition(int[] arr, int m) {

        // Minimum possible time = max single board length
        int start = max(arr);

        // Maximum possible time = sum of all board lengths
        int end = sum(arr);

        int ans = -1;

        // Binary search on maximum allowed time
        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Check if we can paint all boards using at most m painters such that no painter paints more than 'mid' time
            if (isPossible(arr, m, mid)) {
                ans = mid;          // mid is possible, try to minimize it
                end = mid - 1;
            } else {
                start = mid + 1;   // need more time
            }
        }

        return ans;
    }

    // Checks if it is possible to paint all boards using at most m painters such that no painter exceeds maxAllowedTime
    public static boolean isPossible(int[] arr, int m, int maxAllowedTime) {

        int painter = 1;
        int time = 0;

        for (int i = 0; i < arr.length; i++) {

            if (time + arr[i] <= maxAllowedTime) {
                // Assign current board to the same painter
                time += arr[i];
            } else {
                // Assign board to a new painter
                painter++;
                time = arr[i];
            }
        }

        // If required painters are within limit
        return painter <= m;
    }

    // Returns the maximum value in the array
    public static int max(int[] arr) {

        int maxTime = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxTime = Math.max(arr[i], maxTime);
        }

        return maxTime;
    }

    // Returns the sum of all elements in the array
    public static int sum(int[] arr) {

        int totalTime = 0;

        for (int i = 0; i < arr.length; i++) {
            totalTime += arr[i];
        }

        return totalTime;
    }
}