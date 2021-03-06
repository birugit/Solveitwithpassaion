package com.techniques.tree.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 Given a binary tree and a number āSā,
 find all paths in the tree such that the sum of all the node values of each path equals āSā.
 Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).

 Example 1:
 1
 7
 9
 6
 5
 2
 3
 S: 12
 Output: 3
 Explaination: There are three paths with sum '12':7 -> 5, 1 -> 9 -> 2, and 9 -> 3
 */
public class CountAllPathSum {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        CountAllPathSum p = new CountAllPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);

        int sum = 12;
        System.out.println(p.countPaths(root, sum));

    }

    private int countPaths(TreeNode root, int sum) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, sum, currentPath);
    }

    private int countPathsRecursive(TreeNode root, int sum, List<Integer> currentPath) {
        if(root == null)
            return 0;

        //add the current node to the path
        currentPath.add(root.val);
        int pathCount = 0, pathSum = 0;

        //find the sums of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while(pathIterator.hasPrevious()){
            pathSum += pathIterator.previous();

            //if the sum of any sub-path is equal to 'S' we increment our path count
            if(pathSum == sum){
                pathCount++;
            }
        }

        //traverse the left subtree
        pathCount += countPathsRecursive(root.left, sum, currentPath);

        //traverse the right subtree
        pathCount += countPathsRecursive(root.right, sum, currentPath);

        //remove current node from the path to backtrack,
        //we need to remove the current node while we are going up the recursive call stack
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }

}
