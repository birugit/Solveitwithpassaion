package com.oct;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * @author swamy on 10/23/20
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class MinDepthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int mindepth = recusrionMinDepth(root);
        System.out.println(mindepth);
    }

    private static int recusrionMinDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if((root.left == null) && (root.right == null)){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(recusrionMinDepth(root.left), min_depth);
        }
        if(root.right != null){
            min_depth = Math.min(recusrionMinDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
