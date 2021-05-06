package com.fb.twoheaps;

import java.util.PriorityQueue;

/**
 * @author swamy on 3/4/21
 */
public class FindMedianOfNumberStream {
    private  PriorityQueue<Integer> maxHeap;
    private  PriorityQueue<Integer> minHeap;

  public static void main(String[] args) {
      FindMedianOfNumberStream f = new FindMedianOfNumberStream();
      f.insert(1);
      f.insert(2);
      System.out.println(f.findMedian());
      f.insert(3);
      System.out.println(f.findMedian());

  }

  private double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    }
    return maxHeap.peek();
  }

    public FindMedianOfNumberStream(){
      maxHeap = new PriorityQueue<>((a, b)-> b-a);
      minHeap = new PriorityQueue<>((a, b) -> a - b);
  }

  private void insert(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }

    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }
}
