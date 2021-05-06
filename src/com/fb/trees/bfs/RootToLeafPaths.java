package com.fb.trees.bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author swamy on 3/1/21
 */
public class RootToLeafPaths {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
      RootToLeafPaths r = new RootToLeafPaths();
     TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.right = new TreeNode(5);
      List<String> res = r.binaryTreePaths(root);
      System.out.println(res);
  }

    /**
     * T: O(N)
     * S: O(N)
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null)
            return paths;


        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }
}
