package com.fb;

/**
 * @author swamy on 1/3/21
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;

    }
}
public class SwapNodesInPair {

    static ListNode root;
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //Time: O(N)  ->N is the size of linked list
        //Space: O(N) --> N is the space used for recursion call stack
        //	 ListNode afterSwap= swapNodesInPairs(head);
        //	System.out.println(head);

        //Time: O(N) --> N is the size of Linked list
        //Space: O(1)
        ListNode afteriter = swapNodesInPairIterative(head);
        while(afteriter!= null) {
            System.out.println(afteriter.val);
            afteriter= afteriter.next;
        }
    }

    private static ListNode swapNodesInPairIterative(ListNode head) {
        //dummy node acts as the prevNode for the head node
        //of the list and hence stores pointer to the head node

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while((head != null) && (head.next != null)) {
            //Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;


            //Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next;  //jump
        }
        //return the new head
        return dummy.next;
    }

    private static ListNode swapNodesInPairs(ListNode head) {
        //take a temp node
        //swap it with next node

        if(head == null || head.next == null) {
            return head;
        }

        //Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        //swapping
        firstNode.next = swapNodesInPairs(secondNode.next);
        secondNode.next = firstNode;

        //Now the head is the second node
        return secondNode;
    }


}
