package com.company.linkedlist;

public class RemoveNthNodeFromEnd {
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



    public Node removeNthFromEnd(Node head, int n) {
        int count =0;
        Node current = head;
        while(current!=null){
            count+=1;
            current= current.next;
        }
        if(n==count)return head.next;
        // System.out.print(count);
        Node curr=head;
        Node prev= null;
        int i =0;
        while(curr!=null){
             if(count==n){
                prev.next=curr.next;
                curr.next=null;
                break;
            }

            prev = curr;
            curr=curr.next;
            count--;
        }


        return head;
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

    void printList(Node head){
        Node current= head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }

    public static void main(String[] args){
        RemoveNthNodeFromEnd ob1= new RemoveNthNodeFromEnd();
        Node headNode= null;
        headNode=ob1.push(headNode,7);
        headNode=ob1.push(headNode,9);
        headNode=ob1.push(headNode,9);
        headNode=ob1.push(headNode,1);
        headNode=ob1.push(headNode,4);
        Node result= ob1.removeNthFromEnd(headNode,2);
        ob1.printList(result);
    }
}
