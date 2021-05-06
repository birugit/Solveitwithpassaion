package com.techniques.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Example 2:
 *
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums ={1, 3, 3};
       List<List<Integer>> res=s.findSubsets(nums);
       System.out.println(res);
    }

    private List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        for(int n: nums){
            int size = resList.size();
            for(int i=0; i< size; i++){
                List<Integer> set = new ArrayList<>(resList.get(i));
                set.add(n);
                resList.add(set);
            }
        }

        return resList;

    }

}
