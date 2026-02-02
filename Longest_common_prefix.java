import java.util.Arrays;

/*
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)   (ignoring sorting overhead)
 *
 * Sorts the array of strings and compares only the first and last strings to find the longest common prefix.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Sort the array of strings lexicographically
        Arrays.sort(strs);

        // After sorting, the common prefix of the whole array
        // must be the common prefix of the first and last strings
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int idx = 0;

        // Compare characters of the first and last strings
        while (idx < s1.length() && idx < s2.length()) {

            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        // Return the common prefix
        return s1.substring(0, idx);
    }
}
