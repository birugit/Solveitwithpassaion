package com.fb;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * @author swamy on 1/28/21
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {1,5,8,4,7,6,5,3,1};
        n.nextPermutation(nums);
    }

    /**
     * Intution:
     * //1,5,8,4,7,6,5,3,1
     * 1.find decreasing number {4,7,6,5,3,1}
     * 2.find the number larger than 4, i.e 5
     * 3. swap 4 and 5
     * 4. reverse 7,6,5,3,1  becomes 1,3,5,6,7
     *T: O(N)
     * S:O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //find decreasing number {4,7,6,5,3,1}
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //find the number larger than 4, i.e 5
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //swap 4 and 5
            swap(nums, i, j);
        }
        //reverse 7,6,5,3,1  becomes 1,3,5,6,7
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
