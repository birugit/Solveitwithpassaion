package com.techniques.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree and a number ‘S’,
 find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

 Example 1:
 1
 7
 9
 4
 5
 2
 7
 S: 12
 Output: 2
 Explaination: There are the two paths with sum '12':1 -> 7 -> 4 and 1 -> 9 -> 2

 */
public class AllPathSum {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
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

        int sum = 12;
      List<List<Integer>>  res=AllPathSum.findAllPath(root, sum);
    System.out.println(res);
    }

    private static List<List<Integer>> findAllPath(TreeNode root, int sum) {

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        addAllPaths(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void addAllPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
    if(root == null)
        return;

     currentPath.add(root.val);
     if(root.val == sum && root.left == null && root.right == null)
         allPaths.add(new ArrayList<>(currentPath));
    else {
         addAllPaths(root.left, sum - root.val, currentPath, allPaths);
         addAllPaths(root.right, sum - root.val, currentPath, allPaths);
     }
    //remove current node from root to backtrack
        //we need to remove current node while moving up call tack
        currentPath.remove(currentPath.size() - 1);

    }
}
