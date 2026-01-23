/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Uses Dutch National Flag Algorithm to sort the array
 * containing only 0s, 1s, and 2s in a single pass.
 */

class Solution {
    // Helper method to swap two elements in the array
    public void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public void sortColors(int[] nums) {

        // left  -> boundary for 0s
        // mid   -> current element
        // right -> boundary for 2s
        int left = 0, right = nums.length - 1;
        int mid = left;

        // Process elements until mid crosses right
        while (mid <= right) {

            if (nums[mid] == 1) {
                // 1 is already in correct position
                mid++;

            } else if (nums[mid] == 0) {
                // Place 0 at the left boundary
                swap(nums, left, mid);
                left++;
                mid++;

            } else {
                // Place 2 at the right boundary
                // Do NOT increment mid here, as swapped value needs checking
                swap(nums, mid, right);
                right--;
            }
        }

        return;
    }
}
