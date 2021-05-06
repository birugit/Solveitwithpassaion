package com.fb.linkedlist.iterative;

import java.util.List;

/**
 * @author swamy on 3/4/21
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
      ReverseList r =  new ReverseList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        ListNode res = r.reverse(head);

        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }

  }

    private ListNode reverse(ListNode head) {
        ListNode current = head;//current node that we will be processing
        ListNode previous = null;//previous node that we have processed
        ListNode next = null;//will be used to store temporarly store hte next node
        while(current!= null){
            next = current.next;//temporaraly store the current
            current.next = previous;//reverse the current node
            previous = current;//before we move to next node, point previous to current
            current =next;//move on the next

        }
        return previous;
    }
}
