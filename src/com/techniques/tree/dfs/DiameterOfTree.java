package com.techniques.tree.dfs;

/**
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 * <p>
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 * <p>
 * Example 1:
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * Output: 5
 * Explaination: The diameter of the tree is: [4, 2, 1, 3, 6]
 */
public class DiameterOfTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        //   int sum = 12;
        int res = findDiameter(root);
        System.out.println(res);
    }

    static int treeDiameter = 0;

    private static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }

    private static int calculateHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftTreeHeight = calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);

        //diameter at the current node will be equal to the height of left subtree +
        //the height of right sub-trees + '1' for current node
        int diameter = leftTreeHeight + rightTreeHeight + 1;

        //update the global tree diameter
        treeDiameter = Math.max(treeDiameter, diameter);

        //height of the current node will be equal to the maximum of the heights of
        //left or right subtrees plus '1' for the current node
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

}
