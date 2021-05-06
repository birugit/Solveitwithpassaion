package com.techniques.tree.dfs;

/**
 Find the path with the maximum sum in a given binary tree.
 Write a function that returns the maximum sum.
 A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.

 Example 1:
 1
 2
 3
 4
 5
 6
 Output: 16
 Explanation: The path with maximum sum is: [4, 2, 1, 3, 6
 */
public class PathWithMaxSum {
    private static int globalMaxSum;
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
        int res = findMaxSum(root);
        System.out.println(res);
    }

    private static int findMaxSum(TreeNode root) {
        globalMaxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return globalMaxSum;
    }

    private static int findMaxPathSum(TreeNode currentNode) {
        if(currentNode == null)
            return 0;

        int maxPathSumLeft = findMaxPathSum(currentNode.left);
        int maxPathSumRight = findMaxPathSum(currentNode.right);

        //ignore paths with negative sums, since we need to find the maximum sum we should
        //ignore any path which has an overall negative sum.
        maxPathSumLeft = Math.max(maxPathSumLeft, 0);
        maxPathSumRight = Math.max(maxPathSumRight, 0);

        //maximum path sum at the current node will be equal to the sum from the left subtree +
        // the sum from right subtree + val of current node
        int localMaxSum = maxPathSumLeft + maxPathSumRight + currentNode.val;

        //upgrade the global maximum sum
        globalMaxSum = Math.max(globalMaxSum, localMaxSum);

        //maximum sum of any path from the current node will be equal to the maximum of
        //the sums from left or right subtrees plus the value of the current node
        return Math.max(maxPathSumLeft, maxPathSumRight) + currentNode.val;

    }


}
