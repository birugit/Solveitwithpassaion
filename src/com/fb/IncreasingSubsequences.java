package com.fb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences
 * of the given array, and the length of an increasing subsequence should be at least 2.
 *
 * <p>Example:
 *
 * <p>Input: [4, 6, 7, 7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7],
 * [7,7], [4,7,7]]
 *
 * @author swamy on 2/17/21
 */
public class IncreasingSubsequences {
  public static void main(String[] args) {
      IncreasingSubsequences i = new IncreasingSubsequences();
      int[] nums = {4, 6, 7, 7};
      List<List<Integer>> res = i.findSubsequences(nums);
      System.out.println(res);

  }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1)
            res.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i]))
                continue;
            if(list.size()==0 || nums[i] >= list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }
}
