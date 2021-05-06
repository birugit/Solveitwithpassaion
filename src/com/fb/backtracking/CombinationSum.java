package com.fb.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * \return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * @author swamy on 1/29/21
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
    int[] nums = {3, 4, 5};//{2, 3, 6, 7};
    int target = 8;//7;
        List<List<Integer>> list = c.combinationSum(nums, target);
        //list.stream().flatMap(l-> l.stream()).forEach(s-> System.out.print(s));
        list.stream().forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    /**
     * Complexity Analysis
     *T: O(N(T/M+1))
     * S:O(T/M)
     * N= number of nodes
     * T=target value
     * M = minimal value
     * N -ary tree max depth = T/M
     *
     * Let N be the number of candidates, T be the target value, and MM be the minimal value among the candidates.
     *
     * Time Complexity: \mathcal{O}(N^{\frac{T}{M}+1})O(N
     * M
     * T
     * ​
     *  +1
     *  )
     *
     * As we illustrated before, the execution of the backtracking is unfolded as a DFS traversal in a n-ary tree. The total number of steps during the backtracking would be the number of nodes in the tree.
     *
     * At each node, it takes a constant time to process, except the leaf nodes which could take a linear time to make a copy of combination. So we can say that the time complexity is linear to the number of nodes of the execution tree.
     *
     * Here we provide a loose upper bound on the number of nodes.
     *
     * First of all, the fan-out of each node would be bounded to NN, i.e. the total number of candidates.
     *
     * The maximal depth of the tree, would be \frac{T}{M}
     * M
     * T
     * ​
     *  , where we keep on adding the smallest element to the combination.
     *
     * As we know, the maximal number of nodes in N-ary tree of \frac{T}{M}
     * M
     * T
     * ​
     *   height would be N^{\frac{T}{M}+1}N
     * M
     * T
     * ​
     *  +1
     *  .
     *
     * Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound, since the fan-out of the nodes are decreasing level by level.
     *
     * Space Complexity: \mathcal{O}(\frac{T}{M})O(
     * M
     * T
     * ​
     *  )
     *
     * We implement the algorithm in recursion, which consumes some additional memory in the function call stack.
     *
     * The number of recursive calls can pile up to \frac{T}{M}
     * M
     * T
     * ​
     *  , where we keep on adding the smallest element to the combination. As a result, the space overhead of the recursion is \mathcal{O}(\frac{T}{M})O(
     * M
     * T
     * ​
     *  ).
     *
     * In addition, we keep a combination of numbers during the execution, which requires at most \mathcal{O}(\frac{T}{M})O(
     * M
     * T
     * ​
     *  ) space as well.
     *
     * To sum up, the total space complexity of the algorithm would be \mathcal{O}(\frac{T}{M})O(
     * M
     * T
     * ​
     *  ).
     *
     * Note that, we did not take into the account the space used to hold the final results for the space complexity.
     * @param list
     * @param tempList
     * @param nums
     * @param remain
     * @param start
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
      //1. exceed the target value, cease exploration
        if(remain < 0)
            return;
        //2. fulfilled desired target, therefore add current combination to the list
        else if(remain == 0)
            list.add(new ArrayList<>(tempList));
        else{
            //3. next exploration start from cursor start
            for(int i = start; i < nums.length; i++){
                //4. add current candidate to combination
                tempList.add(nums[i]);
                //5.With added candidate, we have less sum to fulfill i.e remain - candidate
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                //6. at the end of each exploration , backtrack by popping out  the candidate out of combination
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
