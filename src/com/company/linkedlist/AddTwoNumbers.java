package com.company.linkedlist;

import org.w3c.dom.Node;

public class AddTwoNumbers {
    static class Node{
        int data;
        Node next;
        Node(){

        }

        Node(int data)
        {
            this.data= data;
            next=null;
        }
    }
     Node push(Node headNode,int data){
        if (headNode==null){
            headNode= new Node(data);
            return headNode;
        }
        Node node = new Node(data);
        Node current= headNode;
        while (current.next!=null){
            current=current.next;
        }
        current.next= node;
        node.next=null;
        return headNode;
    }


        Node addTwo(Node list1, Node list2){
        Node d = new Node();
        Node result= d;
        int carry=0;
        while (list1!=null || list2!=null && carry!=0){
            int sum=0;
            if (list1!=null){
                sum=sum+list1.data;
                list1= list2.next;
            }
            if (list2!=null){
                sum=sum+list2.data;
                list2= list2.next;
            }
            sum=sum+carry;
            d.next= new Node(sum%10);
            carry= sum/10;
            d= d.next;
        }
        return result.next;
    }


     void printList(Node head){
        Node current= head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }

    public static void main(String[] args)
    {
        AddTwoNumbers ob1= new AddTwoNumbers();
        Node headNode = null;
        Node headNode1= null;
        headNode=ob1.push(headNode,7);
        headNode=ob1.push(headNode,9);
        headNode=ob1.push(headNode,9);
        headNode=ob1.push(headNode,1);
        headNode1=ob1.push(headNode1,5);
        headNode1=ob1.push(headNode1,9);
        headNode1=ob1.push(headNode1,3);
        headNode1=ob1.push(headNode1,2);

        Node result = ob1.addTwo(headNode, headNode1);
        ob1.printList(result);

    }
}
