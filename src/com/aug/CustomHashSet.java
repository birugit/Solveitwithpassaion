package com.aug;

public class CustomHashSet {
    public static void main(String[] args) {
        CustomHashSet hashSet = new CustomHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }
    class Node {
        int key;
        Node next;
        public Node(int key) {
            this.key = key;
        }
    }

    private Node[] nodes;

    /** Initialize your data structure here. */
    public CustomHashSet() {
        nodes = new Node[10000 + 11];
    }

    public int hash(int key) {
        return key % nodes.length;
    }

    public void add(int key) {
        int idx = hash(key);
        if (nodes[idx] == null) {
            nodes[idx] = new Node(key);
        } else {
            Node cur = nodes[idx];
            while (cur.next != null && cur.key != key) {
                cur = cur.next;
            }
            if (cur.key != key) {
                cur.next = new Node(key);
            }
        }
    }

    public void remove(int key) {
        int idx = hash(key);
        if (nodes[idx] == null) {
            return ;
        } else if (nodes[idx].key == key) {
            nodes[idx] = nodes[idx].next;
        } else {
            Node cur = nodes[idx], pre = null;
            while (cur.next != null && cur.key != key) {
                pre = cur;
                cur = cur.next;
            }
            if (cur.key == key) {
                pre.next = cur.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = hash(key);
        Node cur = nodes[idx];
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        return cur != null;
    }
}
