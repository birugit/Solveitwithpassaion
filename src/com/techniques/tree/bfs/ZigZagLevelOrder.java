package com.techniques.tree.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
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
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        List<List<Integer>> res = ZigZagLevelOrder.zigzagLevelOrderTraversal(root);
        System.out.println(res);
    }

    private static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
        LinkedList<List<Integer>> zigzagLevelOrder = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean isLevelChange = false;
        while(!que.isEmpty()){
            int size = que.size();

            LinkedList<Integer> currentList = new LinkedList<>();
            for(int i= 0; i<size; i++){
                TreeNode currentNode = que.poll();
                if(!isLevelChange)
                    currentList.addLast(currentNode.val);
                else
                currentList.addFirst(currentNode.val);

                if(currentNode.left != null){
                    que.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    que.offer(currentNode.right);
                }
            }
            if(currentList!= null)
                zigzagLevelOrder.add(currentList);
            isLevelChange=!isLevelChange;
        }
        return  zigzagLevelOrder;
    }
}
