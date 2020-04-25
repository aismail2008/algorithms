package com.code.test.problemset.CrackingCodingInterview6.ch7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q12_Hasher<K, V> {
    public static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value;

        public LinkedListNode(K k, V v) {
            key = k;
            value = v;
        }

        public LinkedListNode(int val, Object o, LinkedListNode current) {
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

    private ArrayList<LinkedListNode<K, V>> arr;

    public Q12_Hasher(int capacity) {
        /* Create list of linked lists. */
        arr = new ArrayList<>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    /* Insert key and value into hash table. */
    public V put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value; // just update the value.
            return oldValue;
        }

        node = new LinkedListNode<>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    /* Remove node for key. */
    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            /* Removing head - update. */
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    /* Get value for key. */
    public V get(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    /* Get linked list node associated with a given key. */
    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /* Really stupid function to map a key to an index. */
    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }

    public static void main(String[] args) {
        Q12_Hasher_Ali arr = new Q12_Hasher_Ali(5);

        arr.get(3);
        arr.put(4,5);
        arr.remove(2);
    }

    static class Q12_Hasher_Ali<K, V> {
        class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private ArrayList<LinkedList<Node>> arr;
        private int capacity;

        public Q12_Hasher_Ali(int capacity) {
            this.capacity = capacity;
            /* Create list of linked lists. */
            arr = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                arr.add(null);
            }
        }

        /* Insert key and value into hash table. */
        public V put(K key, V value) {

            Node node = getNodeForKey(key);
            if (node != null) {
                V oldValue = node.value;
                node.value = value; // just update the value.
                return oldValue;
            }

            node = new Node(key, value);
            int index = getIndexForKey(key);
            if (arr.get(index) == null) {
                arr.set(index, new LinkedList<>());
            }
            arr.get(index).add(node);

            return null;
        }

        /* Remove node for key. */
        public V remove(K key) {
            Node node = getNodeForKey(key);
            if (node == null) {
                return null;
            }

            arr.get(getIndexForKey(key)).remove(node);
            return node.value;
        }

        /* Get value for key. */
        public V get(K key) {
            if (key == null) return null;
            Node node = getNodeForKey(key);
            return node == null ? null : node.value;
        }

        /* Get linked list node associated with a given key. */
        private Node getNodeForKey(K key) {
            int index = getIndexForKey(key);
            LinkedList<Node> current = arr.get(index);
            while (current != null) {
                for (int i = 0; i < current.size(); i++) {
                    if (current.get(i).key == key)
                        return current.get(i);
                }
            }
            return null;
        }

        /* Really stupid function to map a key to an index. */
        public int getIndexForKey(K key) {
            return Math.abs(key.hashCode() % capacity);
        }
    }
}