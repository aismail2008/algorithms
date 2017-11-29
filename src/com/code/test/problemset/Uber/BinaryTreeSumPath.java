package com.code.test.problemset.Uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliismail on 27/11/2017.
 */
public class BinaryTreeSumPath {
//    You are given a binary tree in which each node contains an integer value.
//    List all paths that sum to a given target value.
//    The path does not need to start or end at the root or a leaf, but it must go downwards
//    (traveling only from parent nodes to child nodes).

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static List<List<Node>> paths = new ArrayList<>();

    public static void findSum(int target, int remain,  Node root, List<Node> path) {
        if (root.key == remain) {
            path.add(root);
            paths.add(path);
        }
        else if (root.key < remain) {
            path.add(root);
            if (root.left != null){
                findSum(target, remain - root.key, root.left, new ArrayList<>(path));
            }
            if (root.right != null){
                findSum(target, remain - root.key, root.right, new ArrayList<>(path));
            }
        }

        if(root.right != null){
            findSum(target, target, root.right, new ArrayList<>());
        }
        if(root.left != null){
            findSum(target, target, root.left, new ArrayList<>());
        }
    }

    public static void main(String[] args){

        Node t1 = new Node(5);
        Node t2 = new Node(2);
        Node t3 = new Node(1);
        t3.left = t1;
        t3.right = t2;

        Node t4 = new Node(2);
        Node t5 = new Node(9);
        Node t6 = new Node(4);
        t6.left = t4;
        t6.right = t5;

        Node t7 = new Node(3);
        t7.left = t3;
        t7.right = t6;


        findSum(6, 6, t7, new ArrayList<>());
        for(List<Node> n : paths){
            n.forEach( r ->{
                System.out.print(r.key + "->");
            });
            System.out.println();
            System.out.println("====");
        }
    }
}
