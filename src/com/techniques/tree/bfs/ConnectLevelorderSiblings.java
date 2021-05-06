package com.techniques.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelorderSiblings {
    static class TreeNode{
        int val;
        TreeNode left, right, next;
        public TreeNode(int val){
            this.val = val;
        }

        public void printLevelorder() {
            TreeNode nextLevelRoot = this;
            while(nextLevelRoot != null){
                TreeNode current = nextLevelRoot;
                nextLevelRoot = null;
                while(current != null){
                    System.out.println(current.val + " ");
                    if(nextLevelRoot == null){
                        if(current.left != null){
                            nextLevelRoot = current.left;
                        }else if(current.right != null){
                            nextLevelRoot = current.right;
                        }
                        current = current.next;
                    }
                    System.out.println();
                }
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
         ConnectLevelorderSiblings.connectSiblings(root);
      //  System.out.println(res);
        root.printLevelorder();
    }

    private static void connectSiblings(TreeNode root) {
        if(root == null)
            return;;

            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while(!que.isEmpty()){
                TreeNode previousNode = null;
                int levelSize = que.size();

                for(int i=0; i< levelSize; i++){
                    TreeNode currentNode = que.poll();
                    if(previousNode != null){
                        previousNode.next = currentNode;
                    }
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
}
