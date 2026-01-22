/*
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 *
 * Merges two sorted arrays in-place by filling nums1
 * from the end to avoid overwriting existing elements.
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer to the last index of nums1
        int end_idx = nums1.length - 1;

        // Merge elements from the back while both arrays have elements
        while (m > 0 && n > 0) {

            // Compare last valid elements of nums1 and nums2
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[end_idx] = nums2[n - 1]; // place larger element
                n--;
            } else {
                nums1[end_idx] = nums1[m - 1];
                m--;
            }

            // Move the pointer backward
            end_idx--;
        }

        // Copy remaining elements from nums2 (if any)
        // No need to copy nums1 elements as they are already in place
        while (n > 0) {
            nums1[end_idx--] = nums2[n - 1];
            n--;
        }

        return;
    }
}