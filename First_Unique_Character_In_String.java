/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Uses a frequency array to count occurrences
 * of each character, then finds the first
 * character with frequency 1.
 */
class Solution {

    public int firstUniqChar(String s) {

        // Frequency array for 'a' to 'z'
        int[] freq = new int[26];

        // Step 1: Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == 1) return i;
        }

        return -1;
    }
}