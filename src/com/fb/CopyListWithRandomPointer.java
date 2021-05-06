package com.fb;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * @author swamy on 12/30/20
 */
public class CopyListWithRandomPointer {
    static class RandomNode{
        int val;
        RandomNode next, random;
        RandomNode(int val){
            this.val = val;
            this.random = null;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        RandomNode head = new RandomNode(7);
     //   Node head = new Node(1);
        RandomNode two = new RandomNode(13);
        RandomNode three = new RandomNode(11);
        RandomNode four = new RandomNode(10);
        RandomNode five = new RandomNode(1);

        head.next = two;
        head.random = null;

        two.next = three;
        two.random = head;

        three.next = four;
        three.random = five;

        four.next = five;
        four.random = three;

        five.next = null;
        five.random = head;

        RandomNode node = copyRandomListNode(head);

        while(node != null){
            System.out.println(node.val+" ");
            node = node.next;
        }

    }

    private static RandomNode copyRandomListNode(RandomNode head) {
        if(head == null)
            return head;
        RandomNode node = head;

        //first loop, add copy after node directly
        while(node !=null){
            RandomNode next = node.next;
            node.next = new RandomNode(node.val);
            node.next.next = next;
            node = next;
        }

       // After loop: 1 - 1' - 2 - 2' - 3 s- 3' - 4 - 4'

        //second loop, link random for copyhead
        node = head;
        while(node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //third loop: divide into head and copy head
        node = head;
        RandomNode copyHead = node.next;//it is 1' initially
        RandomNode copy = copyHead;//its is 1' initially
        while(copy.next != null){
            //first copy.next is 2
            node.next = node.next.next;// in the first loop node.next is 2
            node = node.next;//th first loop, node now is 2
            copy.next = copy.next.next;//in first loop, copy next is 2'
            copy = copy.next;//in first loop copy is 2'
        }
        //last step
        node.next = node.next.next;
        return copyHead;
    }
}
