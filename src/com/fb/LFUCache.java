package com.fb;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author swamy on 1/1/21
 */
public class LFUCache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    private int min;

    private final int capacity;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;

        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key); // remove key from current count (since we will inc count)
        if (count == min && countToLRUKeys.get(count).size() == 0) min++; // nothing in the current min bucket

        putCount(key, count + 1);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value); // update key's value
            get(key); // update key's count
            return;
        }

        if (keyToVal.size() >= capacity)
            evict(countToLRUKeys.get(min).iterator().next()); // evict LRU from this min count bucket

        min = 1;
        putCount(key, min); // adding new key and count
        keyToVal.put(key, value); // adding new key and value
    }

    private void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }

    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }
/*best sol with DLink
    private static class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        public MyDeque deque;
    }

    private static class MyDeque {
        public int idx;
        public MyDeque next;
        public MyDeque prev;
        public Node head;
        public Node tail;
    }

    private Node[] nodes;
    private MyDeque useDeques;
    private int capacity;
    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.nodes = new Node[10001];
    }

    public int get(int key) {

        Node node = getNode(key);


        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {

        Node node = getNode(key);
        if (this.capacity < 1) return;

        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;

            if (this.capacity == this.size) {
                removeLFU();
                this.size--;
            }
            if (this.useDeques == null) {
                this.useDeques = new MyDeque();
            }
            if (this.useDeques.idx != 1) {
                this.useDeques = prependDeque(this.useDeques, 1);
            }

            addNode(node, this.useDeques);
            nodes[key] = node;
            this.size++;
        } else {
            node.value = value;
            nodes[node.key] = node;
        }
    }

    public Node getNode(int key) {
        Node node = nodes[key];
        if (node != null) incrementUseIdx(node);
        return node;
    }

    // propagate the node to the next deque
    private void incrementUseIdx(Node node) {

        MyDeque priorUseDeque = node.deque;
        MyDeque nextUseDeque = getOrAddNextDeque(priorUseDeque);

        this.removeNode(node);
        this.addNode(node, nextUseDeque);

        boolean isPriorDequeEmpty = priorUseDeque.head == null;

        if (isPriorDequeEmpty) {
            this.removeDeque(priorUseDeque);
            boolean isLfuDequeEmpty = this.useDeques == priorUseDeque;
            if (isLfuDequeEmpty) this.useDeques = nextUseDeque;
        }
    }

    /// get the next use deque or create a new one if next deque isn't +1
    private MyDeque getOrAddNextDeque(MyDeque useDeque) {
        boolean isNextUseDequeAvaiable = useDeque.next != null && useDeque.idx + 1 == useDeque.next.idx;

        return  isNextUseDequeAvaiable ? useDeque.next : this.addDequeAfter(useDeque);
    }

    private void removeLFU() {
        MyDeque lfuDeque = this.useDeques;
        Node lfuNode = removeNode(lfuDeque.head);
        boolean isUseDequeEmpty = lfuDeque.head == null;

        if (isUseDequeEmpty) {
            MyDeque oldLfuDeque = removeDeque(lfuDeque);
            this.useDeques = oldLfuDeque.next;
        }

        this.nodes[lfuNode.key] = null;
    }
    private void addNode(Node node, MyDeque deque) {
        Node oldTail = deque.tail;


        if (oldTail != null) oldTail.next = node;

        node.prev = oldTail;
        node.next = null;

        node.deque = deque;

        if (deque.head == null) deque.head = node;

        deque.tail = node;
    }

    private MyDeque prependDeque(MyDeque deque, int idx) {

        MyDeque newDeque = new MyDeque();
        MyDeque oldPrev = deque.prev;

        newDeque.idx = idx;
        newDeque.next = deque;
        deque.prev = newDeque;
        if (oldPrev != null) oldPrev.next = newDeque;

        return newDeque;
    }

    private MyDeque addDequeAfter(MyDeque deque) {
        MyDeque newDeque = new MyDeque();

        newDeque.idx = deque.idx + 1;

        deque.next  = newDeque;
        newDeque.prev = deque;

        return newDeque;
    }

    private MyDeque removeDeque(MyDeque deque) {
        if (deque == null) return deque;
        MyDeque prevDeque = deque.prev;
        MyDeque nextDeque = deque.next;

        if (prevDeque != null) prevDeque.next = nextDeque;
        if (nextDeque != null) nextDeque.prev = prevDeque;

        return deque;
    }
    private Node removeNode(Node node) {
        if (node == null) return node;
        Node prev = node.prev;
        Node next = node.next;
        MyDeque deque = node.deque;

        if (node == deque.head) deque.head = node.next;
        if (node == deque.tail) deque.tail = node.prev;

        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;

        return node;
    }*/
}

