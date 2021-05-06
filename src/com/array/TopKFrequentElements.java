package com.array;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3,
                3};//{1,1,1,2,2,3};
        int k = 3;
        int[] res = topKFrequent(nums, k);
        for (int n : res) {
            System.out.println(n);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        int[] res = new int[k];
        for (Integer top : map.keySet()) {
            pq.offer(top);
            if (pq.size() > k)
                pq.poll();
        }
        int len = pq.size();
        for (int i = 0; i < len; i++)
            res[i] = pq.poll();

        return res;
    }
}
