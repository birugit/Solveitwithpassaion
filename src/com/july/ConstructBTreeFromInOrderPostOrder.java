package com.july;

import java.util.HashMap;

/**
 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 inorder = [9,3,15,20,7]
 postorder = [9,15,7,20,3]
 Return the following binary tree:

 3
 / \
 9  20
 /  \
 15   7
 */
public class ConstructBTreeFromInOrderPostOrder {

    int post_index;
    static int[] postorder;
    static int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ConstructBTreeFromInOrderPostOrder c = new ConstructBTreeFromInOrderPostOrder();
        //TreeNode root = new TreeNode(1);
       /* root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);*/

        int sum = 10;
      inorder = new int[]{9, 3, 15, 20, 7};
        postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode res = c.buildTree(inorder, postorder);
    printTree(res);

    }

    private static void printTree(TreeNode res) {
        if(res == null)
            return;
        printTree(res.left);
        System.out.println(res.val);
        printTree(res.right);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        this.post_index = postorder.length -1;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length -1);

    }

    public TreeNode helper(int left, int right) {
        if(left > right){
            return null;
        }

        //find the root value
        TreeNode root = new TreeNode(postorder[post_index]);
        int mid_index = idx_map.get(root.val);

        //recursion
        post_index --;

        //build the tree
        root.right = helper(mid_index + 1, right);
        root.left = helper(left,mid_index-1);
        return root;

    }
}
