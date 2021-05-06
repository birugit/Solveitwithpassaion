package com.fb.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given all the nodes of an N-ary tree as an array of Node objects, where each node has a
 * unique value.
 *
 * <p>Return the root of the N-ary tree.
 *
 * <p>Custom testing:
 *
 * <p>An N-ary tree can be serialized as represented in its level order traversal where each group
 * of children is separated by the null value (see examples).
 *
 * <p>For example, the above tree is serialized as
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].
 *
 * <p>The testing will be done in the following way:
 *
 * <p>The input data should be provided as a serialization of the tree. The driver code will
 * construct the tree from the serialized input data and put each Node object into an array in an
 * arbitrary order. The driver code will pass the array to findRoot, and your function should find
 * and return the root Node object in the array. The driver code will take the returned Node object
 * and serialize it. If the serialized value and the input data are the same, the test passes.
 *
 * @author swamy on 2/17/21
 */
public class FindRootOfNAryTree {
    static class Node{
        int val;
        Node left, right;
        List<Node> children;
        Node(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
    List<Node> children = new ArrayList<>();
   // children.add(new Node(1), new Node(2),new Node(3));
  }
    public Node findRoot(List<Node> tree) {
        // Edge Case
        if (tree == null || tree.size() == 0)
            return null;

        long sumWithoutRoot = 0;
        long sumWithRoot = 0;

        // For each node in the tree
        for (Node node : tree) {
            // All the sums
            sumWithRoot += node.val;

            // All the sums without root
            for (Node child : node.children)
                sumWithoutRoot += child.val;
        }

        // Only root can make sum = sumWithRoot
        for (Node node : tree)
            if (node.val + sumWithoutRoot == sumWithRoot) return node;

        return null;
    }
}
