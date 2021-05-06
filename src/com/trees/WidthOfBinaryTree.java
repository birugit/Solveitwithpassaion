package com.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 * @param <T>
 */
public class WidthOfBinaryTree<T> {
    static class TreeNode<T> {
        T val;
        TreeNode left;
        TreeNode right;

        public TreeNode(T val) {
            this.val = val;
        }

        public static void main(String[] args) {
            /*
              1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
             */
            WidthOfBinaryTree<Integer> bTree = new WidthOfBinaryTree<>();
            TreeNode<Integer> root = new TreeNode<>(1);
            root.left = new TreeNode<>(3);
            root.right = new TreeNode<>(2);
            root.left.left = new TreeNode<>(5);
            root.left.right = new TreeNode<>(3);
            root.right.right = new TreeNode<>(9);

            int width = bTree.findWidhtOfBtree(root);
            System.out.println(width);

            int w = bTree.widthOfBinaryTree(root);
            System.out.println(w);

        }
    }

    //BFS
    /*
    Time: O(N) visit each node once and only once, each visit take constant time to process
    Space: O(N) using LinkedList queue to store nodes, due to BFS nature, each time it holds not more than tow levels of Nodes
    that is N/2 nodes. so space O(N)
     */
    private Integer findWidhtOfBtree(TreeNode<T> root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qI = new LinkedList<>();
        q.offer(root);
        qI.offer(0);
        int res = 0, left = 0, right = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            left = 0;
            right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                int index = qI.remove();

                if (i == 0)
                    left = index;
                if (i == size - 1)
                    right = index;
                if (node.left != null) {
                    q.add(node.left);
                    qI.offer(2 * index);
                }
                if (node.right != null) {
                    q.add(node.right);
                    qI.offer(2 * index + 1);
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /*
    DFS

     */
    private int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new LinkedList<>();
        helper(root, 0, 1, startOfLevel);
        return max;
    }

    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null)
            return;
        if (level == list.size())
            list.add(index);
        max = Math.max(max, index + 1 - list.get(level));
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }
}
