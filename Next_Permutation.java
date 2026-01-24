/* Problem: https://leetcode.com/problems/next-permutation/

   Time Complexity: O(n)

   Space Complexity: O(1)
   - In-place modifications, no extra space used.
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        int i = n - 1;
        //find first decreasing element(pivot) from right side
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        //find next greater element than the pivot from right
        int j = n;
        if(i >= 0){
            while(nums[j] <= nums[i]){
                j--;
            }
            //swap pivot and its next greater element
            swap(nums, i, j);
        }
        reverse(nums, i+1, n);
    }

    public void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void reverse(int[] arr, int l, int r){
        while(l < r){
            swap(arr, l, r);
            l++;
            r--;
        }
    }
}