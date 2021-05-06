package com.fb.trees.bfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author swamy on 3/6/21
 */
public class KthSmallestElement {
    static class TreeNode{
        TreeNode left, right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        KthSmallestElement k = new KthSmallestElement();
      TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(12);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(8);
        int res = k.kthSmallest(root, 2);
        System.out.println(res);
    }
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Integer> smallestElements = new PriorityQueue<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode popped = queue.remove();
            if (!(popped.left == null))
                queue.add(popped.left);
            if (!(popped.right == null))
                queue.add(popped.right);
            smallestElements.add(popped.val);
        }
        int kthSmallestElement = 0;
        while (k-- >= 0) {
            kthSmallestElement = smallestElements.remove();
        }
        return kthSmallestElement;
    }
}
