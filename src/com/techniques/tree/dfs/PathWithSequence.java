package com.techniques.tree.dfs;

/**
 Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

 Example 1:
 Sequence: [1, 9, 9]
 Output: true
 Explaination: The tree has a path 1 -> 9 -> 9.
 1
 7
 9
 2
 9
 */
public class PathWithSequence {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        PathWithSequence p = new PathWithSequence();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        int[] sequence = {1, 9, 9};
        System.out.println(p.findSequence(root, sequence));

    }

    boolean findSequence(TreeNode root, int[] sequence){

        return findSequencePath(root, sequence, 0);
    }

    private static boolean findSequencePath(TreeNode root, int[] sequence, int seqIndex) {
        if(root == null)
            return false;

        if(seqIndex >= sequence.length || root.val != sequence[seqIndex])
            return false;

        //if the current node is a leaf and its value is end of the sequence, we've found a path
        if(seqIndex == sequence.length - 1 && root.left == null && root.right == null)
            return true;

        //recursively call to traverse the left and right sub-tree
        //return true if any of the recursive call return true
        return findSequencePath(root.left, sequence,seqIndex + 1) ||
                findSequencePath(root.right, sequence,seqIndex + 1);

    }
}
