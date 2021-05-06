package com.fb.heap;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * @author swamy on 1/16/21
 */
public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};//123456
        int k = 2;

        int res = f.findKthLargest(nums, k);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
