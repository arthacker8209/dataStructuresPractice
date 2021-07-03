package com.company.linkedlist;

import javax.swing.*;

public class CountSmallerElementInRightSideAVLTREES {
    static class Node{
        int data, size,height;
        Node left, right;
        Node(int data){
            this.data= data;
            size=1;
            height=1;
            left=right=null;
        }
    }

    private static int height(Node node){
        if (node==null) return 0;
        return node.height;
    }
    private static int size(Node node){
        if (node==null)return 0;
        return node.size;
    }

    private static int max(int a, int b){
        return (a>b)?a:b;
    }

    private static int getBalance(Node node){
        if (node==null)return 0;
        return height(node.left)-height(node.right);
    }

    private static Node leftRotate(Node node){
        Node temp1= node.right;
        Node temp2= temp1.left;
        temp1.left= node;
        node.right= temp2;

        node.height= max(height(node.left), height(node.right))+1;
        temp1.height= max(height(temp1.left), height(temp1.right))+1;

        node.size= max(size(node.left), size(node.right))+1;
        temp1.size= max(size(temp1.left), size(temp1.right))+1;

        return temp1;
    }


    private static Node rightRotate(Node node){
        Node temp1= node.left;
        Node temp2= temp1.right;
        temp1.right= node;
        node.left= temp2;

        node.height= max(height(node.left), height(node.right))+1;
        temp1.height= max(height(temp1.left), height(temp1.right))+1;

        node.size= max(size(node.left), size(node.right))+1;
        temp1.size= max(size(temp1.left), size(temp1.right))+1;

        return temp1;
    }

    private static Node insert(Node node , int data , int count){
        if (node==null){
            return new Node(data);
        }
        if (data< node.data){
            node.left = insert(node.left, data, count);
        }
        else {
            node.right= insert(node.right, data, count);
            count= count+size(node.left)+1;
        }

        node.height= max(height(node.left), height(node.right))+1;
        node.size= max(size(node.left), size(node.right))+1;

        int balance= getBalance(node);

        if (balance>1 && data< node.left.data){
            return rightRotate(node);
        }
        if (balance< -1 && data> node.right.data){
            return leftRotate(node);
        }

        if (balance> 1 && data> node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data< node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }


    private static void lowerArray(int[] array , int[] countSmaller , int n ) {

        int i , j;
        Node node = null;
        for (i =0; i<n ; i++){
            countSmaller[i]= 0;
        }


        for (j = n-1; j>=0; j--){
            node= insert(node, array[j], countSmaller[j]);
        }
    }

       private static int[] array = {10,6,15,20,30,5,7};
       private static int n = array.length;
       private static int[] low = new int[n];

    public static void main(String[] args){
        lowerArray(array, low, n);
        for (int i = 0 ; i< n; i++){
            System.out.print(low[i]+ " ");
        }
    }
}
