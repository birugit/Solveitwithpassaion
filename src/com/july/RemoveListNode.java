package com.july;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveListNode {
    // static ListNode root = new ListNode();
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

  /*  @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        while(root!=null) {
            sb.append(val+" -> ");
            root = root.next;
        }

                return sb.toString();
    }*/

    }

    public RemoveListNode() {
        // root = new ListNode();
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(6);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);
        int val = 6;
        ListNode res = RemoveListNode.removeElements(root, val);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;

        ListNode curr = head;

        while (curr != null) {


            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
