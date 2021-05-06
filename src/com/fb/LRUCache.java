package com.fb;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * @author swamy on 12/29/20
 */

public class LRUCache<K, V> {

    DLinkNode<K,V> head, tail;
    int size =0;
    int capacity;
    Map<K, DLinkNode<K,V>> cache = new HashMap<>();

    class DLinkNode<K, V>{
        K key;
        V value;
        DLinkNode<K, V> prev, next;
    }

    LRUCache(int capacity){
        this.capacity = capacity;
        head = new DLinkNode<>();
        tail = new DLinkNode<>();

        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<String, String>(2);
        lruCache.put("Sam", "one");
        lruCache.put("Tam", "two");
        System.out.println(lruCache.get("Sam"));
        System.out.println(lruCache.get("Tam"));
        lruCache.put("Ran", "three");
        System.out.println(lruCache.get("Sam"));//Evicted to place Ran
        System.out.println(lruCache.get("Ran"));
    }

    private V get(K key) {
        DLinkNode<K, V> node = cache.get(key);
        if(node != null)
            moveToHead(node);
        return node == null? (V) "Not Found": node.value;

    }

    private void put(K key, V value) {
        DLinkNode<K,V> node = cache.get(key);
        if(node == null){
            DLinkNode<K,V> newNode = new DLinkNode<>();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);

            addNode(newNode);
            ++size;

            if(size > capacity){
                DLinkNode<K,V> tail = popTail();
                cache.remove(tail.key);
                --size;
            }

        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkNode<K,V> node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkNode<K,V> popTail() {
        DLinkNode<K,V> res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkNode<K,V> res) {
        DLinkNode<K, V> prev = res.prev;
        DLinkNode<K, V> next = res.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNode(DLinkNode<K,V> newNode) {
        //add immediately after head
        newNode.prev = head;
        newNode.next = head.next;

        head.next.prev = newNode;
        head.next = newNode;
    }

}
