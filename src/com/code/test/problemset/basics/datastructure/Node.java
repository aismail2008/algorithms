package com.code.test.problemset.basics.datastructure;

public class Node {
    public int key;
    public Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
