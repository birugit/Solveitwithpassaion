package com.fb.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author swamy on 3/14/21
 */
public class CycleInList {
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
      CycleInList c = new CycleInList();
    //Input: head = [3,2,0,-4], pos = 1
      Node head = new Node(3);
      head.next = new Node(2);
      head.next.next = new Node(0);
      head.next.next.next = new Node(-4);
      head.next.next.next.next = head.next;
      //boolean res = c.hasCycleHash(head);
      boolean res = c.findCycle(head);
      System.out.println(res);
  }

    private boolean findCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }


    public boolean hasCycleHash(Node head) {
        Set<Node> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }
}
