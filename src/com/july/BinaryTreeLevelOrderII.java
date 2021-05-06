package com.july;

import java.util.*;

public class BinaryTreeLevelOrderII {
    public static void main(String[] args) {
        BinaryTreeLevelOrderII b = new BinaryTreeLevelOrderII();
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        List<List<Integer>> res = b.levelOrderTraversal(root);
        System.out.println(res);
    }

    private List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<Node> que = new LinkedList<Node>();
        if(root == null)
            return res;
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i< size; i++){
                Node temp = que.poll();
                if(temp.left != null)
                    que.offer(temp.left);
                if(temp.right != null){
                    que.offer(temp.right);
                }
                list.add(temp.val);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}

class Node{
    int val;
    Node left, right;
    public Node(int val){
        this.val = val;
    }
}
