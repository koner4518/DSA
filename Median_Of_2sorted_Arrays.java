/*
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 *
 * Merges both sorted arrays into a single sorted array and then finds the median from the merged array.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        // Merged sorted array
        int[] arr = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Merge both arrays
        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        // Copy remaining elements of nums1 (if any)
        while (i < m) {
            arr[k++] = nums1[i++];
        }

        // Copy remaining elements of nums2 (if any)
        while (j < n) {
            arr[k++] = nums2[j++];
        }

        int len = arr.length;

        // Middle index (left middle for even length)
        int idx = (len - 1) / 2;

        // If total length is odd
        if (len % 2 == 1) {
            return (double) arr[idx];
        }

        // If total length is even
        return (double) (arr[idx] + arr[idx + 1]) / 2;
    }
}