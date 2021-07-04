package com.company.linkedlist;
import java.util.Stack;
public class CheckPalindrome {
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data= data;
            next=null;
        }
    }

    private static Node headNode;
    private static void push(int data){
        if (headNode==null){
            headNode= new Node(data);
            return;
        }
        Node node = new Node(data);
        Node current= headNode;
        while (current.next!=null){
            current=current.next;
        }
        current.next= node;
        node.next=null;
    }

    private static boolean isPalindrome(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node current= head;
        boolean isPal= false;
        while (current!=null){
            stack.push(current);
            current=current.next;
        }
        current= head;
        while (!stack.isEmpty()){
            Node node = stack.pop();
            int val = node.data;
            if (val==current.data){
                isPal=true;
                current= current.next;
            }
            else {
                isPal=false;
                break;
            }
        }
        return isPal;
    }



    public static void main(String[] args){
        push(1);
        push(3);
        push(3);
        push(1);
        boolean result= isPalindrome(headNode);
        System.out.println(result);
    }
}
