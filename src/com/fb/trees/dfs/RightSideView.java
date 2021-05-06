package com.fb.trees.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author swamy on 2/7/21
 */
public class RightSideView {
    static class TreeNode{
        int val;
      TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        RightSideView r = new RightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode( 3);
        root.right.left = new TreeNode( 6);
        root.right.right = new TreeNode( 4);

        List<Integer> res = r.rightSideView(root);
        res.stream().forEach(System.out::println);
    }
    List<Integer> rightside = new ArrayList();


    /**
     * Everyone likes recursive DFS, so let's add it here as well.
     * The idea is simple: to traverse the tree level by level, starting each time from the rightmost child.
     * T: O(N)
     * S:O(H) worst case skewed Tree O(n)
     * @param node
     * @param level
     */
    public void helper(TreeNode node, int level) {
        if (level == rightside.size())
            rightside.add(node.val);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}
