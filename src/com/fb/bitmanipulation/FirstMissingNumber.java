package com.fb.bitmanipulation;

/**
 * @author swamy on 3/1/21
 */
public class FirstMissingNumber {
  public static void main(String[] args) {
      FirstMissingNumber f = new FirstMissingNumber();
      int[] nums = {3, 0, 1};
      int res= f.findMissingNum(nums);
      System.out.println(res);
  }

  /**
   * Intuition
   *
   * <p>We can harness the fact that XOR is its own inverse to find the missing element in linear
   * time.
   *
   * <p>Algorithm
   *
   * <p>Because we know that nums contains n numbers and that it is missing exactly one number on
   * the range [0..n-1], we know that n definitely replaces the missing number in nums.
   * Therefore, if we initialize an integer to nn and XOR it with every index and value, we will be
   * left with the missing number. Consider the following example (the values have been sorted for
   * intuitive convenience, but need not be):
   *
   * <p>Index 0 1 2 3 Value 0 1 3 4 \begin{aligned} missing &= 4 \wedge (0 \wedge 0) \wedge (1
   * \wedge 1) \wedge (2 \wedge 3) \wedge (3 \wedge 4) \\ &= (4 \wedge 4) \wedge (0 \wedge 0) \wedge
   * (1 \wedge 1) \wedge (3 \wedge 3) \wedge 2 \\ &= 0 \wedge 0 \wedge 0 \wedge 0 \wedge 2 \\ &= 2
   * \end{aligned} missing ​
   *
   * <p> =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
   *     =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
   *     =0∧0∧0∧0∧2 =2
   *T:O(n)
   * S:O(1)
   * @param nums
   * @return
   */
  private int findMissingNum(int[] nums) {
      int missing = nums.length;
      for(int i =0; i<nums.length; i++){
          System.out.println("missing:"+missing+"^=i : "+i+" ^nums: "+nums[i]);
          missing ^= i ^ nums[i];
      }
      return missing;
    }
}
