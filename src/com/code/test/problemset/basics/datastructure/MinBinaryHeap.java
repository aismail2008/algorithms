package com.code.test.problemset.basics.datastructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinBinaryHeap {
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    /**
     * This will initialize our heap with default size.
     */
    public MinBinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);

    }

    /**
     * This will check if the heap is empty or not
     * Complexity: O(1)
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * This will check if the heap is full or not
     * Complexity: O(1)
     */
    public boolean isFull() {
        return heapSize == heap.length;
    }


    private int parent(int i) {
        return (i - 1) / d;
    }

    private int leftChild(int i) {
        return d * i + 1;
    }

    private int rightChild(int i) {
        return d * i + 2;
    }

    /**
     * This will insert new element in to heap
     * Complexity: O(log N)
     * As worst case scenario, we need to traverse till the root
     */
    public void insert(int x) {
        if (isFull())
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    /**
     * This will delete element at index x
     * Complexity: O(log N)
     */
    public int delete(int x) {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty, No element to delete");

        int key = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(x);
        return key;
    }

    private void heapifyUp(int index) {
        int val = heap[index];
        while (parent(index) >= 0 && heap[parent(index)] > val) {
            heap[index] = heap[parent(index)];
            heap[parent(index)] = val;
            index = parent(index);
        }
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (heapSize / 2) && pos <= heapSize) {
            return true;
        }
        return false;
    }

    public void heapifyDown(int pos) {
        int smallest = pos;
        while (!isLeaf(pos)) {
            int leftChildIdx = leftChild(pos);
            int rightChildIdx = rightChild(pos);
            if (leftChildIdx < heapSize && heap[smallest] > heap[leftChildIdx]) {
                smallest = leftChildIdx;
            }
            if (rightChildIdx < heapSize && heap[smallest] > heap[rightChildIdx]) {
                smallest = rightChildIdx;
            }

            if (smallest == pos) {
                break;
            } else {
                int smallestVal = heap[smallest];
                heap[smallest] = heap[pos];
                heap[pos] = smallestVal;
                pos = smallest;
            }
        }
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= heapSize / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                    + " LEFT CHILD : " + heap[2 * i]
                    + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    /**
     * This method used to print all element of the heap
     */
    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());


//        System.out.println("===============================");
//        MinBinaryHeap myMinHeap = new MinBinaryHeap(15);
//        myMinHeap.insert(5);
//        myMinHeap.insert(3);
//        myMinHeap.insert(17);
//        myMinHeap.insert(10);
//        myMinHeap.insert(84);
//        myMinHeap.insert(19);
//        myMinHeap.insert(6);
//        myMinHeap.insert(22);
//        myMinHeap.insert(9);
//
//        myMinHeap.printHeap();
//        myMinHeap.print();
//        myMinHeap.delete(1);
//        myMinHeap.printHeap();
    }


    static class MinHeap {
        private int[] Heap;
        private int size;
        private int maxsize;

        private static final int FRONT = 1;

        public MinHeap(int maxsize) {
            this.maxsize = maxsize;
            this.size = 0;
            Heap = new int[this.maxsize + 1];
            Heap[0] = Integer.MIN_VALUE;
        }

        // Function to return the position of
        // the parent for the node currently
        // at pos
        private int parent(int pos) {
            return pos / 2;
        }

        // Function to return the position of the
        // left child for the node currently at pos
        private int leftChild(int pos) {
            return (2 * pos);
        }

        // Function to return the position of
        // the right child for the node currently
        // at pos
        private int rightChild(int pos) {
            return (2 * pos) + 1;
        }

        // Function that returns true if the passed
        // node is a leaf node
        private boolean isLeaf(int pos) {
            if (pos >= (size / 2) && pos <= size) {
                return true;
            }
            return false;
        }

        // Function to swap two nodes of the heap
        private void swap(int fpos, int spos) {
            int tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }

        // Function to heapify the node at pos
        private void minHeapify(int pos) {

            // If the node is a non-leaf node and greater
            // than any of its child
            if (!isLeaf(pos)) {
                if (Heap[pos] > Heap[leftChild(pos)]
                        || Heap[pos] > Heap[rightChild(pos)]) {

                    // Swap with the left child and heapify
                    // the left child
                    if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    }

                    // Swap with the right child and heapify
                    // the right child
                    else {
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
            }
        }

        // Function to insert a node into the heap
        public void insert(int element) {
            if (size >= maxsize) {
                return;
            }
            Heap[++size] = element;
            int current = size;

            while (Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        // Function to print the contents of the heap
        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" PARENT : " + Heap[i]
                        + " LEFT CHILD : " + Heap[2 * i]
                        + " RIGHT CHILD :" + Heap[2 * i + 1]);
                System.out.println();
            }
        }

        // Function to build the min heap using
        // the minHeapify
        public void minHeap() {
            for (int pos = (size / 2); pos >= 1; pos--) {
                minHeapify(pos);
            }
        }

        // Function to remove and return the minimum
        // element from the heap
        public int remove() {
            int popped = Heap[FRONT];
            Heap[FRONT] = Heap[size--];
            minHeapify(FRONT);
            return popped;
        }
    }
}
