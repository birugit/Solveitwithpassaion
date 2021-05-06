package com.fb;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author swamy on 1/2/21
 */
public class BTreeLevelOrderTraversal {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {
        BTreeLevelOrderTraversal btree = new BTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list = btree.levelOrder(root);
        System.out.println(list);

    }

    //iterative
    //T:O(N) S:O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        //  Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.poll();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }

	/* List<List<Integer>> levels = new ArrayList<List<Integer>>();

	    public void helper(TreeNode node, int level) {
	        // start the current level
	        if (levels.size() == level)
	            levels.add(new ArrayList<Integer>());

	         // fulfil the current level
	         levels.get(level).add(node.val);

	         // process child nodes for the next level
	         if (node.left != null)
	            helper(node.left, level + 1);
	         if (node.right != null)
	            helper(node.right, level + 1);
	    }

	    public List<List<Integer>> levelOrder(TreeNode root) {
	        if (root == null) return levels;
	        helper(root, 0);
	        return levels;
	    }
*/

}
