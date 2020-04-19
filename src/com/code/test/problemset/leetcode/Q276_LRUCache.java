package com.code.test.problemset.leetcode;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 /_ capacity _/ );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * https://leetcode.com/problems/lru-cache/
 */
public class Q276_LRUCache {
    class LRUCache {
        private int maxCacheSize;
        private HashMap<Integer, LinkedListNode> map = new HashMap<>();
        private LinkedListNode listHead = null;
        public LinkedListNode listTail = null;


        public LRUCache(int maxSize) {
            maxCacheSize = maxSize;
        }

        /* Get value for key and mark as most recently used. */
        public int get(int key) {
            LinkedListNode item = map.get(key);
            if (item == null) {
                return -1;
            }

            /* Move to front of list to mark as most recently used. */
            if (item != listHead) {
                removeFromLinkedList(item);
                insertAtFrontOfLinkedList(item);
            }
            return item.value;
        }

        /* Remove node from linked list. */
        private void removeFromLinkedList(LinkedListNode node) {
            if (node == null) {
                return;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == listTail) {
                listTail = node.prev;
            }
            if (node == listHead) {
                listHead = node.next;
            }
        }

        /* Insert node at front of linked list. */
        private void insertAtFrontOfLinkedList(LinkedListNode node) {
            if (listHead == null) {
                listHead = node;
                listTail = node;
            } else {
                listHead.prev = node;
                node.next = listHead;
                listHead = node;
                listHead.prev = null;
            }
        }

        /* Remove key, value pair from cache, deleting from hash table
         * and linked list. */
        public boolean removeKey(int key) {
            LinkedListNode node = map.get(key);
            removeFromLinkedList(node);
            map.remove(key);
            return true;
        }

        /* Put key, value pair in cache. Removes old value for key if
         * necessary. Inserts pair into linked list and hash table.*/
        public void put(int key, int value) {
            /* Remove if already there. */
            removeKey(key);

            /* If full, remove least recently used item from cache. */
            if (map.size() >= maxCacheSize && listTail != null) {
                removeKey(listTail.key);
            }

            /* Insert new node. */
            LinkedListNode node = new LinkedListNode(key, value);
            insertAtFrontOfLinkedList(node);
            map.put(key, node);
        }

        public String getCacheAsString() {
            if (listHead == null) return "";
            return listHead.printForward();
        }

        private class LinkedListNode {
            private LinkedListNode next;
            private LinkedListNode prev;
            public int key;
            public int value;
            public LinkedListNode(int k, int v) {
                key = k;
                value = v;
            }

            public String printForward() {
                String data = "(" + key + "," + value + ")";
                if (next != null) {
                    return data + "->" + next.printForward();
                } else {
                    return data;
                }
            }
        }
    }
}
