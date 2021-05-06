package com.fb.trees.dfs;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * @author swamy on 2/7/21
 */
public class LowestCommonAncestorofBT {
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){

            this.val = val;
        }
    }
    public static void main(String[] args) {
        LowestCommonAncestorofBT l= new LowestCommonAncestorofBT();
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);//8
        TreeNode res = l.lowestCommonAncestor(root, p, q);
        System.out.println(res.val);


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    /*
    public TreeNode backtrack(TreeNode root, TreeNode p, TreeNode q) {

        // the line below is the most hard to understand
        // for the first level recursion, if p(or q) is exactly the whole tree's root, return the root(because root is the lowest node).
        // for deeper(higher nodes) recursions, it indicates:
        // (1) we find p(or q), which is fine because this node will not be returned(to output) instantly since it belongs to a deeper recursion but will be used for determinations of shallower(lower nodes) recursions
        // (2) we reach the bottom of the tree, terminate the current track instantly and "null" will also be used for shallower recursions' determine statements.
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = backtrack(root.left, p, q);
        TreeNode right = backtrack(root.right, p, q);

        // determine statements

        if (left != null && right != null) // which means p,q exist below different subtrees;
            return root;

        return left != null ? left : right; // which means p,q exist below the same subtree;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return backtrack(root, p, q);

    }*/
}
