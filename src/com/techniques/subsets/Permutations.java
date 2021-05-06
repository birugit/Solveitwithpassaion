package com.techniques.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a set of distinct numbers, find all of its permutations.
 *
 * Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:
 *
 * {1, 2, 3}
 * {1, 3, 2}
 * {2, 1, 3}
 * {2, 3, 1}
 * {3, 1, 2}
 * {3, 2, 1}
 * If a set has ‘n’ distinct elements it will have
 * n
 * !
 * n! permutations.
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations  p = new Permutations();
        int[] nums = {1, 2, 3};
      //  List<List<Integer>> res = p.findPermuatations(nums);
        //System.out.println(res);

        List<List<Integer>> res = p.findPermuatationsRecursive(nums);
        System.out.println(res);
    }

    private List<List<Integer>> findPermuatationsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generatePermutationsRecursive(int[] nums, int index, ArrayList<Integer> currentPermutations, List<List<Integer>> result) {
        if(index == nums.length)
            result.add(currentPermutations);
        else{
            //create a new permutation by adding the current number at every position
            for(int i=0; i<= currentPermutations.size(); i++){
                ArrayList<Integer> newPermutation = new ArrayList<>(currentPermutations);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index+1, newPermutation, result);
            }
        }
    }

    //T: O(N * N!)
    //T: O(N * N!)
    private List<List<Integer>> findPermuatations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for(int currentNum: nums){
            //take all existing permutations and add the current number to create new permutations
            int size = permutations.size();
            for(int i=0; i<size; i++) {
                List<Integer> oldPermutations = permutations.poll();
                //create a new permutation by adding the current number at every position
                for(int j = 0; j<= oldPermutations.size(); j++){
                    List<Integer> newPermutations = new ArrayList<>(oldPermutations);
                    newPermutations.add(j, currentNum);
                    if(newPermutations.size() == nums.length){
                        result.add(newPermutations);
                    }else{
                        permutations.add(newPermutations);
                    }
                }
            }
        }
        return result;
    }
}
