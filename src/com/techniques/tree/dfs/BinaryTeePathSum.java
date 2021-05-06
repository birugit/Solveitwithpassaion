package com.techniques.tree.dfs;

/**
 Given a binary tree and a number ‘S’,
 find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.

 1
 2
 3
 4
 5
 6
 7
 S: 10
 Output: trueExplaination: The path with sum '10' is highlighted
 Example 1:
 Example 2:
 12
 7
 1
 9
 10
 5
 S: 23Output: trueExplaination: The path with sum '23' is highlighted  S: 16Output: falseExplaination: There is no root-to-leaf path with sum '16'.

 */
public class BinaryTeePathSum {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int sum = 10;
        System.out.println(findPath(root, sum));

    }

    private static boolean findPath(TreeNode root, int sum) {
        if(root == null)
            return false;

        //if the current node is a leaf and its value is equal to the sum, we've found a path
        if(root.val == sum && root.left == null && root.right == null)
            return true;

        //recursively call to traverse the left and right sub-tree
        //return true
        return findPath(root.left, sum - root.val) || findPath(root.right, sum - root.val);

    }
}
