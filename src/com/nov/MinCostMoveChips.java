package com.nov;

/**
 * ntuition
 *
 * Notice that we have two types of costs:
 *
 * Costs 0 when moving to position[i] + 2 or position[i] - 2.
 * Costs 1 when moving to position[i] + 1 or position[i] - 1.
 * Since move to position[i] + 2 or position[i] - 2 is free, it is natural to think that firstly moving chips as close as possible, with 0 cost.
 *
 * In fact, we can move all chips at even positions to position 0, and move all chips at the odd positions to position 1.
 *
 * Then, we only have many chips at position 0 and other chips at position 1. Next, we only need to move those two piles together.
 *
 * Given two piles of chips located at 0 and 1 respectively, intuitively it would be less effort-taking (i.e. less cost) to move the smaller pile to the larger one, which makes the total cost to:
 *
 * Cost = min(even\_cnt, odd\_cnt)Cost=min(even_cnt,odd_cnt)
 *
 * where even\_cnteven_cnt represents the number of chips at the even positions, and odd\_cntodd_cnt represents the number of chips at the odd positions.
 *
 * Good, now we have a not bad cost. Can we do better?
 *
 * Well, now we will prove that this cost is the smallest possible one.
 *
 * As for the final position of those chips pile, there are only two possibilities:
 *
 * The final position is at the even position, or
 * The final position is at the odd position.
 * In the first case, we at least need to cost odd_cnt to move all the chips at the odd positions to the even positions. Similarly, in the second case, we at least need to cost even_cnt.
 *
 * Therefore, min(even_cnt, odd_cnt) is the smallest possible cost.
 *
 * In conclusion, the policy we gave above will achieve the smallest possible cost. What we need to return is just min(even_cnt, odd_cnt).
 *
 * Algorithm
 *
 * We just need to count the number of chips at the even positions and the number of chips at the odd positions and return the smaller one.
 * @author swamy on 11/5/20
 */
public class MinCostMoveChips {
    public static void main(String[] args) {
        MinCostMoveChips m = new MinCostMoveChips();
        /**
         * Input: position = [1,2,3]
         * Output: 1
         * Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
         * Second step: Move the chip at position 2 to position 1 with cost = 1.
         * Total cost is 1.
         */

        /*
        Input: position = [2,2,2,3,3]
        Output: 2
        Explanation: We can move the two chips at poistion 3 to position 2. Each move has cost = 1. The total cost = 2.
         */
        int chips[] = {2,2,2,3,3};//{1, 2, 3};
        int cost = m.minCostToMoveChips(chips);
        System.out.println(cost);
    }

/**
T: O(N) - iterate all elements
 S: O(1)
 */
    public int minCostToMoveChips(int[] position) {
        int even_cnt = 0;
        int odd_cnt = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                even_cnt++;
            } else {
                odd_cnt++;
            }
        }
        return Math.min(odd_cnt, even_cnt);
    }
}
