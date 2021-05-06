package com.fb.trees.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author swamy on 3/1/21
 */
public class  RootToLeafPaths {
    static class TreeNode{
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
      List<String> res = r.findPaths(root);
      System.out.println(res);
  }

    /**
     * T:O(N)
     * Traverse each node once
     *
     * S:O(N) pr O(logN)
     * storing paths take LogN, ignore as call stack takes more
     * call stack in worst case take O(N), best case(balanced tree) its O(logN)
     *
     * @param root
     * @return
     */
    private List<String> findPaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        constructpath(root, "", paths);
        return paths;
    }

    private void constructpath(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // if reach a leaf
                paths.add(path);  // update paths
            else {
                path += "->";  // extend the current path
                constructpath(root.left, path, paths);
                constructpath(root.right, path, paths);
            }
        }
    }
}
