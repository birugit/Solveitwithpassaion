package com.trees;
/**
 * Given all the nodes of an N-ary tree as an array  Node[] tree where each node has a unique value.
 *
 * Find and return the root of the N-ary tree.
 *
 *
 *
 * Follow up:
 *
 * Could you solve this problem in constant space complexity with a linear time algorithm?
 *
 *
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * For example, the above tree is serialized as [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].
 */

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(ArrayList<Node> _children, int _val) {
        val = _val;
        children = _children;
    }
};

public class FindRootOfNArayTree {

    public static void main(String[] args) {
        //1,null,3,2,4,null,5,6

        Node root = new Node(1);

    }
    public Node findRoot(List<Node> tree) {
        int total = 0;
        int children = 0;
        for (Node node : tree) {
            total += node.val;
            children += getValForChildren(node);
        }
        int val = total - children;
        for (Node node : tree) {
            if (val == node.val) {
                return node;
            }
        }
        return null;
    }

    private int getValForChildren(Node node) {
        int sum = 0;
        for (Node n : node.children) {
            sum += n.val;
        }
        return sum;
    }
}
