package com.fb.trees.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * @author swamy on 2/7/21
 */
public class RightSideViewOfTree {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        RightSideViewOfTree r = new RightSideViewOfTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode( 3);
        root.right.left = new TreeNode( 6);
        root.right.right = new TreeNode( 4);

        List<Integer> res = r.rightSideView(root);
        res.stream().forEach(System.out::println);
    }

    /**
     * Initiate the list of the right side view rightside.
     *
     * Initiate the queue by adding a root.
     *
     * While the queue is not empty:
     *
     * Write down the length of the current level: levelLength = queue.size().
     *
     * Iterate over i from 0 to level_length - 1:
     *
     * Pop the current node from the queue: node = queue.poll().
     *
     * If i == levelLength - 1, then it's the last node in the current level, push it to rightsize list.
     *
     * Add first left and then right child node into the queue.
     *
     * Return rightside.
     *
     * T: O(N)
     * S:(D)
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
        List<Integer> rightside = new ArrayList();

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for(int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                // if it's the rightmost element
                if (i == levelLength - 1) {
                    rightside.add(node.val);
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightside;
    }
}
