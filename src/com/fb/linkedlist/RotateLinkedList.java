package com.fb.linkedlist;

import java.util.List;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * @author swamy on 2/21/21
 */
public class RotateLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
      RotateLinkedList r = new RotateLinkedList();
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      ListNode res = r.rotateRight(head,2);
      while(res!=null){
          System.out.println(res.val);
          res = res.next;
      }

  }

    /**
     * T:O(N)
     * S:O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        //1. close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        //2 find new tail : (n - k % n - 1)th node
        //3 and new head : (n - k % n)th node
        ListNode new_tail = head;
    for (int i = 0; i < n - k % n - 1; i++) {
      System.out.println(n - k % n - 1);
      System.out.println(n - k % n );
      new_tail = new_tail.next;
            }
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
