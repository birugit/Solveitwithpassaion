package com.fb.trees.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author swamy on 3/10/21
 */
public class EvenOddTree {
  static class TreeNode{
      int val;
      TreeNode left, right;
      public TreeNode(int val){
          this.val = val;
      }
  }
    public static void main(String[] args) {
        EvenOddTree e = new EvenOddTree();
      //root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);

        boolean isEvenOddTree = e.findEvenOddTree(root);
        System.out.print(isEvenOddTree);
  }

    private boolean findEvenOddTree(TreeNode root) {
      if(root == null)
          return false;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level =0;
        boolean even = true;
        while(!q.isEmpty()){
            int length = q.size();
            int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0; i< length; i++ ){
                TreeNode node = q.poll();
                if(even && (node.val %2 == 0 || node.val <= prevVal))
                    return false;
                if(!even && (node.val %2 == 1 || node.val >= prevVal))
                    return false;
                    prevVal = node.val;
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            even = !even;
        }
        return true;
    }
}
