package com.company.trees.binarytrees;

public class DiameterOfTrees {
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    static class Pair
    {
        int height;
        int diameter;
    }

    private static Pair diameterOfBinaryTree(Node node){

        Pair pair = new Pair();
        pair.height=0;
        pair.diameter=0;
        if (node==null)return pair;
        Pair lp=  diameterOfBinaryTree(node.left);
        Pair rp= diameterOfBinaryTree(node.right);
        pair.height= Math.max(lp.height, rp.height)+1;
        pair.diameter= Math.max(lp.height+rp.height+1, Math.max(lp.diameter, rp.diameter));

        return pair;

    }





    public static void main(String[] args){
        Pair pair = null;
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        pair= diameterOfBinaryTree(root);
        System.out.println(pair.diameter);

    }
}
