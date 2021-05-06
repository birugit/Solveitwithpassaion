package com.fb.trees.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * * Invert a binary tree.
 *  *
 *  * Example:
 *  *
 *  * Input:
 *  *
 *  *      4
 *  *    /   \
 *  *   2     7
 *  *  / \   / \
 *  * 1   3 6   9
 *  * Output:
 *  *
 *  *      4
 *  *    /   \
 *  *   7     2
 *  *  / \   / \
 *  * 9   6 3   1
 * @author swamy on 2/5/21
 */
public class InvertBT {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }

    }
    public static void main(String[] args) {
        InvertBT i = new InvertBT();
        InvertBT.TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode invertTree = i.invertTree(root);
    }

    /**
     * T: O(N)
     * S:(N) //for a full binary tree leaves are n/2 = O(N) leaves
     * @param root
     * @return
     */
    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
