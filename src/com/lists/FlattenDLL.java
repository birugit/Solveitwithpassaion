package com.lists;

public class FlattenDLL {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.child = new Node(3);

        FlattenDLL f = new FlattenDLL();
        Node res = f.flatten(head);
        while(res!= null){
            System.out.println(res.val);
            res  =res.next;
        }


    }
    static class Node{
        int val;
        Node next, prev, child;
        public Node(){

        }
        public Node(int val){

            this.val = val;
        }
    }

    Node flatten(Node head){
        Node ptr = head;
        if(ptr == null)
            return head;
        while(ptr!= null){

            //1. child null, proceed to next
            if(ptr.child == null){
                ptr = ptr.next;
                continue;
            }

            //2. traverse till end of child
            Node tmp = ptr.child;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = ptr.next;
            //3. add child next to ptr
            if(ptr.next != null)
                ptr.next.prev = tmp;

            //4.connect with child
            ptr.next = ptr.child;
            ptr.child.prev = ptr;
            ptr.child = null;
        }
        return head;
    }
}
