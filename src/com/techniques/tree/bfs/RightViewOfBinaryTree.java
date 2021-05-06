package com.techniques.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given a binary tree, return an array containing nodes in its right view. The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.

 1
 2
 3
 4
 5
 6
 7
 Example 1
 Right View: [1, 3, 7]
 */
public class RightViewOfBinaryTree {
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
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        List<Integer> res = RightViewOfBinaryTree.rightView(root);

        System.out.println(res);
    }

    private static List<Integer> rightView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        List<Integer> rightView = new ArrayList<>();
        int idx = 0;
        while (!que.isEmpty()){
            int size = que.size();
            for(int i=0; i< size; i++){
                TreeNode currentNode = que.poll();
                if(i == size - 1)
                    rightView.add( currentNode.val);
                if(currentNode.left != null){
                    que.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    que.offer(currentNode.right);
                }
            }
        }
        return  rightView;
    }

}
