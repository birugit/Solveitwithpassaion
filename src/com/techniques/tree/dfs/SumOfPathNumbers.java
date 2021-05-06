package com.techniques.tree.dfs;

/**
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
 * <p>
 * Example 1:
 * Output: 408 Explaination: The sum of all path numbers: 17 + 192 + 199
 * 1
 * 7
 * 9
 * 2
 * 9
 */
public class SumOfPathNumbers {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);

        //   int sum = 12;
        int res = findAllPathSum(root);
        System.out.println(res);
    }

    private static int findAllPathSum(TreeNode root) {
        return addAllPathsSum(root, 0);
    }

    private static int addAllPathsSum(TreeNode root, int pathSum) {
        if (root == null)
            return 0;
        //calculate path number of the current node
        pathSum = 10 * pathSum + root.val;

        //if the current node is a leaf, return the current path sum
        if (root.left == null && root.right == null)
            return pathSum;
        //traverse the left and the right sub-tree
        return addAllPathsSum(root.left, pathSum) +
                addAllPathsSum(root.right, pathSum);


    }
}
