package com.fb;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author swamy on 12/29/20
 */
class BTreeNode{
    int val;
    BTreeNode left, right;
    BTreeNode(int val)
    {
        this.val = val;
    }
}
public class SerializeAndDeserializeBT {
     String splitter =",";
     String NN = "#";
    public static void main(String[] args) {
        SerializeAndDeserializeBT s = new SerializeAndDeserializeBT();
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(4);
        root.right.left = new BTreeNode(5);
        root.right.right = new BTreeNode(6);
        String res = s.serializeBT(root);
        System.out.println(res);
        BTreeNode desrializeTree = s.desrialize(res);

    }

    private  BTreeNode desrialize(String res) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(res.split(",")));
        return desrializeHelper(dq);
      }

    private  BTreeNode desrializeHelper(Deque<String> dq) {
        String val = dq.poll();
        if(val.equals(NN))
            return null;
        else {
            BTreeNode root = new BTreeNode(Integer.valueOf(val));
            root.left = desrializeHelper(dq);
            root.right = desrializeHelper(dq);
            return root;
        }
    }

    private String serializeBT(BTreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);;
        System.out.println(sb);
        return sb.toString();

    }

    private void serializeHelper(BTreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NN).append(splitter);
        }else {
            sb.append(Integer.valueOf(root.val)).append(splitter);//pre Order traversal
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }
}
