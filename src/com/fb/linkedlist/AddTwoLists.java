package com.fb.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * @author swamy on 1/12/21
 */
public class AddTwoLists {
    Node head;

    public static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            //    this.next = next;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public AddTwoLists() {
        head = null;
    }
    public static void main(String[] args) {

        AddTwoLists l = new AddTwoLists();
       /* AddTwoLists list1 = new AddTwoLists();

        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(4);*/
        Node list1 = new Node(9);
        list1.next = new Node(9);
      // == 1  list1.next.next = new Node(3);

        System.out.println(list1);

      /*  AddTwoLists list2 = new AddTwoLists();
        list2.addLast(7);
        list2.addLast(0);
        list2.addLast(8);*/
        Node list2 = new Node(1);
      //  list2.next = new Node(9);
       // list2.next.next = new Node(9);
        System.out.println(list2);

     //   addLists(list1.head, list2.head);
        Node  res =l.addTwoNumbers(list1, list2);
        while(res!=null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
    public Node addTwoNumbers(Node l1, Node l2) {
        Node c1 = l1;
        Node c2 = l2;
        Node sentinel = new Node(0);
        Node d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new Node(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new Node(1);
        return sentinel.next;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node current = head;
        while(current != null) {
            sb.append(current.val);
            sb.append("-->");
            current = current.next;
        }
        return sb.toString();
    }

    private void addLast(int val) {
        if(head == null) {
            addFirst(val);
        }
        else {
            Node t = head;
            while(t.next != null)
                t = t.next;

            t.next = new Node(val,null);
        }
    }

    private void addFirst(int val) {
        if(head == null)
            head = new Node(val, head);
    }

    //this works only if two lists size is equal
    //if size is not equal, do padding with 0 for less size list
    private static void addLists(Node first, Node second) {
        //	AddTwoLists addTwoLists = new AddTwoLists();
        //Node first = listOne;
        //Node second = listTwo;
        Node temp = null;
        Node result = null;
        Node prev = null;
        //	AddTwoLists res = new AddTwoLists();
        int carry = 0;
        int sum = 0;
        //Node dummyHead = new Node(0, null);
        while((first != null) || (second != null)) {
            int x = (first != null) ? first.val : 0;
            int y = (second != null ) ? second.val : 0;

            sum = x + y + carry;
            System.out.println("sum:"+sum);
            //carry = (sum>=10) ? 1 : 0;
            carry = sum / 10;
            System.out.println("carry: "+carry);
            System.out.println("sum%10: "+sum%10);
            sum = sum % 10;

            temp = new Node(sum, null);

            //if this is the first node then set it as head of result list
            if(result == null) {
                result = temp;
            }else {//if this is not the first node then connect it to the rest
                prev.next = temp;
            }
            //set prev for next insertion
            prev = temp;

            // res.addLast(sum%10);
            if(first != null) {
                first = first.next;
            }
            if(second != null) {
                second = second.next;
            }


        }
        if(carry > 0) {
            // res.addLast(carry);
            temp.next = new Node(carry, null);
        }

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println("");
        //	System.out.println(result.toString());
    }

}
