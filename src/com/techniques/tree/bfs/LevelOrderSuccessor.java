package com.techniques.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given a binary tree and a node, find the level order successor of the given node in the tree.
 The level order successor is the node that appears right after the given node in the level order traversal.

 Example 1:

 3
 4
 Given Node:
 Level Order Successor:
 1
 2
 3
 4
 5
 */
public class LevelOrderSuccessor {
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
        int key = 9;
        TreeNode res=LevelOrderSuccessor.levelOrderSuccessor(root, key);
        System.out.println(res.val);
    /*print reverse order
        for(int i=res.size() -1; i>=0;i--){
            System.out.println(res.get(i));
        }
        */

    }

    private static TreeNode levelOrderSuccessor(TreeNode root, int key) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levelSize = que.size();
            for(int i=0; i< levelSize; i++){
                TreeNode currentNode = que.poll();

                if(currentNode.left != null)
                    que.offer(currentNode.left);
                if(currentNode.right != null)
                    que.offer(currentNode.right);
                if(currentNode.val == key )
                    return que.peek();

            }
        }
        return null;
    }
}
