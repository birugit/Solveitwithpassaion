package com.fb.trees.dfs;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * @author swamy on 2/7/21
 */
public class DiameterOfBT {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        DiameterOfBT d = new DiameterOfBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
       int res =  d.diameterOfBinaryTree(root);
       System.out.println(res);
    }
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    /**
     * Any path can be written as two arrows (in different directions) from some node,
     * where an arrow is a path that starts at some node and only travels down to child nodes.
     *
     * If we knew the maximum length arrows L, R for each child, then the best path touches L + R + 1 nodes.
     * @param node
     * @return
     */
    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}
