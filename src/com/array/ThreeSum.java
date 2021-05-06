package com.array;
/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
       List<List<Integer>> res=t.threeSum(nums);
       System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int sum = a + nums[p] + nums[q];
                if (sum > 0) {
                    q--;
                } else if (sum < 0) {
                    p++;
                } else {
                    res.add(Arrays.asList(a, nums[p], nums[q]));
                    // skip duplicates
                    while (p < q && nums[++p] == nums[p - 1]);
                    while (p < q && nums[--q] == nums[q + 1]);
                }
            }
        }

        return res;
    }
    /*
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi-1])
                            hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }*/
}
