package com.fb.linkedlist.recursive;

import java.util.List;

/**
 * Reverse a singly linked list.
 *
 * <p>Example:
 *
 * <p>Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 *
 * @author swamy on 2/18/21
 */
public class ReverseLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }

    }
  public static void main(String[] args) {
      ReverseLinkedList r = new ReverseLinkedList();
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      ListNode res = r.reverseList(head);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
      }
  }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
