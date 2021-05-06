package com.backtracking;
/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSumII {
    public static void main(String[] args) {
        CombinationsSumII c = new CombinationsSumII();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = c.combinationSum2(candidates, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        combinationSum(0, target, candidates, new ArrayList<Integer>(), res);
        return res;
    }
    private void combinationSum(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(target - candidates[i] < 0)
                break;
            if(i > index && candidates[i] == candidates[i-1])
                continue; // to avoid duplicate cases
            list.add(candidates[i]);
            combinationSum(i+1, target-candidates[i], candidates, list, res);
            list.remove(list.size()-1);
        }
    }
}
