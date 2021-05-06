package com.fb.linkedlist;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author swamy on 2/28/21
 */
public class RemoveDuplicatesInSortedList {
   static  class LinkedNode{
        int val;
        LinkedNode next;
        public LinkedNode(int val){
            this.val = val;
        }

       public LinkedNode() {

       }
   }
  public static void main(String[] args) {
      RemoveDuplicatesInSortedList r = new RemoveDuplicatesInSortedList();
      LinkedNode head = new LinkedNode(1);
      head.next = new LinkedNode(1);
      head.next.next = new LinkedNode(2);
      LinkedNode res = //r.deleteDuplicates(head);
       r.removeDuplicates(head);

     // Stream.of(res).findFirst().ifPresent(System.out::println);
      Stream.of(res).map(m->m.val).forEach(System.out::println);
  }

    private LinkedNode removeDuplicates(LinkedNode head) {

        LinkedNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    //recursive
    public LinkedNode deleteDuplicates(LinkedNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
