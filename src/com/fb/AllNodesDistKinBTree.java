package com.fb;

import java.util.*;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * @author swamy on 1/1/21
 */
public class AllNodesDistKinBTree {
    TreeNode root;
    private  static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        AllNodesDistKinBTree bTree = new AllNodesDistKinBTree();
        bTree.root =new TreeNode(3);
        bTree.root.left = new TreeNode(5);
        bTree.root.right = new TreeNode(1);

        bTree.root.left.left = new TreeNode(6);
        bTree.root.left.right = new TreeNode(2);

        bTree.root.right.left = new TreeNode(0);
        bTree.root.right.right = new TreeNode(8);

        bTree.root.left.right.left = new TreeNode(7);
        bTree.root.left.right.right = new TreeNode(4);

        TreeNode target = new TreeNode(5);
        int K = 2;
        List<Integer> l = distanceK(bTree.root, target, K);
        System.out.println(l);
    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(map, root, null);

        //BFS
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(target.val);
        visited.add(target.val);
        while(!queue.isEmpty() && K-- > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int val = queue.poll();
                for(int next : map.get(val)) {
                    if(visited.add(next))
                        queue.offer(next);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    private static void buildMap(Map<Integer, Set<Integer>> map, TreeNode root, TreeNode parentNode) {
        if(root == null)
            return;
        int val = root.val;
        map.put(val, new HashSet<>());
        if(root.left != null)
            map.get(val).add(root.left.val);
        if(root.right != null)
            map.get(val).add(root.right.val);
        if(parentNode != null)
            map.get(val).add(parentNode.val);
        buildMap(map, root.left, root);
        buildMap(map, root.right, root);
    }

}
