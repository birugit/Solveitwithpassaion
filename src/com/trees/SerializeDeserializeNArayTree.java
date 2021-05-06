package com.trees;

/*
Solve this one in 30 minutes.


/**
* Serialize and deserialize a general (n-ary) Tree
*         A
*      /    |   \
*    B    C    D
*   / \           / | \ \
*  E   F      I  G  H  J
*        |
*       K
*/
/*
A has children B,C,D
        B has children E, F
        F has child K
        D has children I,G,H,J
        C has no children



        */
public class SerializeDeserializeNArayTree {
/*
    public static String serialize(Node root){
        String s = "";
        if(root == null){
            return "";
        }
        s+= "(";
        s += root.value;
        for(int i = 0 ; i < root.getChildSize(); i++){
            String child = serialize(root.getChildAt(i));
            s += child;
        }
        s+= ")";
        return s;
    }

    public static Node deserialize(String s){

        Stack<Node> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(new Node(null));
            } else if (c == ')'){
                Node n = stack.pop();
                if(stack.isEmpty()){
                    return n;
                }
                Node parent = stack.peek();
                parent.addNode(n);
            } else {
                stack.peek().value = String.valueOf(c);
            }
        }
        return null;
    }
*/
}
