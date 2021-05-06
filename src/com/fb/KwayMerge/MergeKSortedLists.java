package com.fb.KwayMerge;

import java.util.PriorityQueue;

/**
 * @author swamy on 3/4/21
 */
public class MergeKSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

      ListNode l2 = new ListNode(3);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(7);

      ListNode l3 = new ListNode(1);
      l3.next = new ListNode(3);
      l3.next.next = new ListNode(4);

      ListNode res = MergeKSortedLists.merge(new ListNode[]{l1, l2, l3});
      while(res!= null){
          System.out.print(res.val+"->");
          res = res.next;
      }
  }

  private static ListNode merge(ListNode[] listNodes) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    // put root of each list in pq
    for (ListNode root : listNodes) {
      if (root != null)
          minHeap.add(root);
    }

    // take smallest element from the minHeap and add it to the result
    // if the top element has a next element add it to the heap
    ListNode resultHead = null, resultTail = null;
    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();
      if (resultHead == null) {
        resultHead = resultTail = node;
      } else {
        resultTail.next = node;
        resultTail = resultTail.next;
      }
      if (node.next != null) {
        minHeap.add(node.next);
      }

    }
      return resultHead;
}

}
