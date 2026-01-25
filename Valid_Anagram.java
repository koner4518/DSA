/* Problem: https://leetcode.com/problems/valid-anagram/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Uses a frequency array of size 26 to compare character counts.
 */

class Solution {
    public boolean isAnagram(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        // If lengths differ, strings cannot be anagrams
        if (n1 != n2) return false;

        // Frequency array for characters 'a' to 'z'
        int[] count = new int[26];

        // Increment for s and decrement for t
        for (int i = 0; i < n1; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, strings are anagrams
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}