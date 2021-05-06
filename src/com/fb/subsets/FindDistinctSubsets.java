package com.fb.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author swamy on 3/4/21
 */
public class FindDistinctSubsets {
  public static void main(String[] args) {
    List<List<Integer>> subset = FindDistinctSubsets.findSubsets(new int[]{1, 3});
    subset.forEach(System.out::println);
  }

  public static List<List<Integer>> findSubsets(int[] nums){
    List<List<Integer>> subsets =   new ArrayList<>();
    //start by adding empty subsets
      subsets.add(new ArrayList<>());
      for(int currNumber: nums){
          //we will add the all existing subsets and insert the current number   in them to create new subsets
          int n = subsets.size();
          for(int i=0; i<n; i++){
              //create a new subset from the existing subset and insert the current element to it
              List<Integer> set = new ArrayList<>(subsets.get(i));
              set.add(currNumber);
              subsets.add(set);
          }
      }
      return subsets;
  }
}
