package com.fb.slidingwindow;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Median
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 Therefore, return the median sliding window as [1,-1,-1,3,5,6]
 * @author swamy on 3/9/21
 */
public class SlidingWindowMedian {
  public static void main(String[] args) {
      SlidingWindowMedian s = new SlidingWindowMedian();
    /**
     * Input: nums=[1, 2, -1, 3, 5], k = 2 Output: [1.5, 0.5, 1.0, 4.0] Explanation: Lets consider
     * all windows of size ‘2’:
     *
     * <p>[1, 2, -1, 3, 5] -> median is 1.5 [1, 2, -1, 3, 5] -> median is 0.5 [1, 2, -1, 3, 5] ->
     * median is 1.0 [1, 2, -1, 3, 5] -> median is 4.0
     */
    int[] nums = {1, 2, -1, 3, 5};
    int k = 2;
    double[] res = s.findMedian(nums, k);
    for(double n : res){
        System.out.print(n+" ");
    }
  }

  //Create maxHeap and MinHeap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * O(N*K)
     * N is number of elements
     * K is length of sliding window
     * inserting and removing elemets take O(logK)
     * removing element going out of winodw take O(k) as we will be searching elem in array of size k
     * S: O(k)
     * @param nums
     * @param k
     * @return
     */
  private double[] findMedian(int[] nums, int k) {
    if (nums.length == 0) return new double[] {0, 0};
    double[] res = new double[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
      if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
        maxHeap.add(nums[i]);
      } else {
        minHeap.add(nums[i]);
      }
      rebalance();

      //check heap have items >= window size
      if (i - k + 1 >= 0) {

        if (maxHeap.size() == minHeap.size()) {
          res[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else {
          res[i - k + 1] = maxHeap.peek();
        }

        //remove element form begining of window
        int removeElemFromWindow = nums[i - k + 1];
        if (removeElemFromWindow <= maxHeap.peek()) {
          maxHeap.remove(removeElemFromWindow);
        } else {
          minHeap.remove(removeElemFromWindow);
        }
        rebalance();
      }
    }
    return res;
  }

    private void rebalance() {
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());

        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
}
