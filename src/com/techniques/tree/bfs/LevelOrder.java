package com.techniques.tree.bfs;

import java.util.*;

public class LevelOrder {
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
      List<List<Integer>>  res=LevelOrder.levelOrderTraversal(root);
        System.out.println(res);
    /*print reverse order
        for(int i=res.size() -1; i>=0;i--){
            System.out.println(res.get(i));
        }
        */

    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        LinkedList<List<Integer>> levelOrder = new LinkedList<>();

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> currentList = new ArrayList<>();
            for(int i =0; i< size; i++){
                TreeNode currentNode = que.poll();
                currentList.add(currentNode.val);
                if(currentNode.left != null){
                    que.offer(currentNode.left);
                 }if(currentNode.right != null){
                    que.offer(currentNode.right);
                }
            }
            if(currentList != null)
            //    levelOrder.addFirst(new ArrayList<>(currentList)); print in reverse order [[4, 5, 2, 7], [7, 9], [1]]
            levelOrder.add(new ArrayList<>(currentList));//[[1], [7, 9], [4, 5, 2, 7]]
        }

        return levelOrder;
    }
}
