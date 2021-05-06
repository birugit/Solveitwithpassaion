package com.fb.cyclicsort;

/**
 * Cyclic sort
 *
 * <p>We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique
 * number from 1 to ‘n’ based on their creation sequence. This means that the object with sequence
 * number ‘3’ was created just before the object with sequence number ‘4’.
 *
 * <p>Write a function to sort the objects in-place on their creation sequence number in O ( n )
 * O(n) and without any extra space. For simplicity, let’s assume we are passed an integer array
 * containing only the sequence numbers, though each number is actually an object.
 *
 * <p>Example 1:
 *
 * <p>Input: [3, 1, 5, 4, 2] Output: [1, 2, 3, 4, 5]
 *
 * @author swamy on 3/8/21
 */
public class SortArray {
  public static void main(String[] args) {
      SortArray s = new SortArray();
      int[] arr = new int[]{2, 6, 4, 3, 1, 5};//{3, 1, 5, 4, 2};
      s.sort(arr);
      for(int n: arr){
          System.out.print(n);
      }
  }

  /**
   * To place a number (or an object in general) at its correct index, we first need to find that
   * number. If we first find a number and then place it at its correct place, it will take us O ( N
   * 2 ) O(N ​2 ​​ ), which is not acceptable.
   *
   * Follow below approach for O(n)
   *
   * <p>Instead, what if we iterate the array one number at a time, and if the current number we are
   * iterating is not at the correct index, we swap it with the number at its correct index. This
   * way we will go through all numbers and place them in their correct indices, hence, sorting the
   * whole array.
   *
   * @param nums
   */
  private void sort(int[] nums) {
      int i =0;
      while(i < nums.length){
          int j = nums[i] - 1;
          if(nums[i] != nums[j])
              swap(nums, i, j);
          else
              i++;
      }
    }
    void swap(int[] nums, int i, int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
}
