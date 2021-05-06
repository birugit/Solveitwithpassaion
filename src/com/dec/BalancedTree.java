package com.dec;

/**
 * @author swamy on 12/22/20
 */
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class BalancedTree {
    public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right= new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
     Boolean isBalanced = isBalanced(root);
     System.out.println(isBalanced);
    }

    private static Boolean isBalanced(TreeNode root) {
        if(root ==null)
            return true;

        return Math.abs(height(root.left) - height(root.right)) < 2 &&
                isBalanced(root.left)
                &&isBalanced(root.right);

    }

    private static int height(TreeNode root) {
        if(root == null)
            return -1;
        return Math.max(height(root.left), height(root.right));
    }
}
