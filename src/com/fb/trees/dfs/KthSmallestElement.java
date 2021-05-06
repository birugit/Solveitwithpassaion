package com.fb.trees.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest
 * element in the tree.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,1,4,null,2], k = 1 Output: 1
 *
 * @author swamy on 3/6/21
 */
public class KthSmallestElement {
   static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(9);
    root.right.left = new TreeNode(7);
      root.right.right = new TreeNode(12);
      root.right.left.left = new TreeNode(4);
      root.right.left.right = new TreeNode(8);
    int res = kthsmall(root, 2);
    System.out.println(res);


  }

    private static int kthsmall(TreeNode root, int k) {
       ArrayList<Object> list = inorder(root, new ArrayList<>());
       return (int) list.get(k);

    }

    private static ArrayList<Object> inorder(TreeNode root, ArrayList<Object> arr) {

       if(root == null)
           return arr;
       inorder(root.left, arr);
       arr.add(root.val);
       inorder(root.right, arr);
       return arr;
    }
}
