package com.lists;

import java.util.PriorityQueue;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();
       Node list1 = new Node(1);
       list1.next = new Node(4);
       list1.next.next = new Node(5);

        Node list2 = new Node(3);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Node list3 = new Node(2);
        list3.next = new Node(8);
        Node[] lists = {list1, list2, list3};

         Node mergedList =   m.mergeLists(lists);
         while(mergedList!= null) {
             System.out.println(mergedList.val);
             mergedList = mergedList.next;
         }
    }

    private Node mergeLists(Node[] lists) {
        Node head = new Node(-1);
        Node ptr = head;
        PriorityQueue<Node> heap = new PriorityQueue<Node>((l1, l2) -> l1.val - l2.val);
       for(Node list: lists){
           heap.add(list);
       }

        while(!heap.isEmpty()){
            ptr.next = heap.poll();
            ptr = ptr.next;
            Node nextPtr = ptr.next;
            if(nextPtr != null){
                heap.offer(nextPtr);
            }
        }
        return head.next;

    }

}
