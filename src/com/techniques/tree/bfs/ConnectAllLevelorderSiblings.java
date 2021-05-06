package com.techniques.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelorderSiblings {
    static class TreeNode{
        int val;
        TreeNode left, right, next;
        public TreeNode(int val){
            this.val = val;
        }

        public void print() {
            TreeNode currentNode = this;
            while(currentNode!= null) {
            System.out.print(currentNode.val+" ");
            currentNode= currentNode.next;
            }
        }
    };



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        ConnectAllLevelorderSiblings.connectAllSiblings(root);
        //  System.out.println(res);
        root.print();
    }

    private static void connectAllSiblings(TreeNode root) {
        if(root == null)
            return;;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode currentNode =null, previousNode = null;
        while(!que.isEmpty()){
            currentNode = que.poll();
            if(previousNode != null)
                previousNode.next = currentNode;
            previousNode = currentNode;

                if(currentNode.left != null){
                    que.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    que.offer(currentNode.right);
                }
            }


    }
}
