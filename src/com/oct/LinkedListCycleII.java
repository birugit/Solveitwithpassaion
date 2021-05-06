package com.oct;

import java.util.HashSet;
import java.util.Set;

/**
 * @author swamy on 10/27/20
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        next = null;
    }
}
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(2);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = list.next;

        ListNode cycle = LinkedListCycleII.detectCycle(list);
        System.out.println(cycle);
    }
/**
T: O(n)
 S: O(n)
 */
    private static ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while(node != null){
            if(visited.contains(node)){
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;

    }
}
