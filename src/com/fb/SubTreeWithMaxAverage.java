package com.fb;

import java.util.Arrays;
import java.util.List;

/**
 *
 * * Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
 * A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.
 *
 * Example 1:
 *
 * Input:
 * 		 20
 * 	   /   \
 * 	 12     18
 *   /  |  \   / \
 * 11   2   3 15  8
 *
 * Output: 18
 * Explanation:
 * There are 3 nodes which have children in this tree:
 * 12 => (11 + 2 + 3 + 12) / 4 = 7
 * 18 => (18 + 15 + 8) / 3 = 13.67
 * 20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125
 *
 * 18 has the maximum average so output 18.
 * @author swamy on 1/2/21
 */
public class SubTreeWithMaxAverage {

    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val)
        { val = _val; }
      /*  public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }*/
    }

    public static void main(String[] args) {
        // Input:
        //              20
        //            /   \
        //          12     18
        //       /  |  \   / \
        //     11   2   3 15  8
        Node left = new Node(12);
        left.children = Arrays.asList(new Node(11), new Node(2), new Node(3));

        Node right = new Node(18);
        right.children = Arrays.asList(new Node(15), new Node(8));

        Node root = new Node(20);
        root.children = Arrays.asList(left, right);

        test(root); // output: 18

    }
    private static void test(Node root) {
        Node maxNode = new SubTreeWithMaxAverage().getMaximumAverage(root);
        System.out.println("Max Average: " + maxNode.val);
    }


    double max;
    Node maxNode;

    public Node getMaximumAverage(Node root) {
        maxNode = null;
        max = Double.MIN_VALUE;

        helper(root);
        return maxNode;
    }

    public double[] helper(Node root) {
        if(root == null) return new double[]{0, 0};
        double count = 1;
        double sum = root.val;

        if(root.children != null) {
            for(Node child: root.children) {
                double[] cur = helper(child);
                sum += cur[0];
                count += cur[1];
            }
        }
        double average = sum / count;
        if(count > 1 && average > max) {
            max = average;
            maxNode = root;
        }
        return new double[]{sum, count};
    }

}
