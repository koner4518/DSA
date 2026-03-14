/*
 * Time Complexity: O(n * 2^n)
 *   - There are 2^n possible subsets. Copying each subset takes O(n)
 *
 * Space Complexity: O(n)
 *   - Recursion stack + temporary subset list
 *
 * Uses Backtracking to generate all subsets while skipping duplicate subsets by sorting the array first.
 */
import java.util.*;

class Solution {


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sort to bring duplicates together
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(nums, 0, subset, subsets);

        return subsets;
    }

    public void helper(int[] nums, int start, List<Integer> subset, List<List<Integer>> subsets) {

        // Add current subset to result
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Choose the element
            subset.add(nums[i]);

            // Recurse for next elements
            helper(nums, i + 1, subset, subsets);

            // Backtrack (remove last element)
            subset.remove(subset.size() - 1);
        }
    }
}