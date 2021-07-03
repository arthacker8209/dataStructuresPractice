package com.company.linkedlist;
public class ListSortingMergeSort {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }}

        private static Node head=null;
     private static void  Push(int newData){
        Node node = new Node(newData);
        node.next=head;
        head=node;
     }
     private static void print(Node root){
         Node current= root;
         while (current!=null){
             System.out.print(current.data+" ");
             current=current.next;
         }
     }
     private static Node middleNode(Node head){
         Node slow, fast;
         slow=head;
         fast=head;
         while (fast.next!=null&& fast.next.next!=null){
             slow=slow.next;
             fast=fast.next.next;
         }
         return slow;
     }

     private static Node mergeSort(Node head){
         if (head==null || head.next==null){
             return head;
         }
         Node middle= middleNode(head);
         Node nextToMiddle= middle.next;
         middle.next=null;
         Node left= mergeSort(head);
         Node right= mergeSort(nextToMiddle);
         Node merged=merge(left,right);
         return merged;
     }

    private static Node merge(Node left, Node right) {
         Node result= null;

         if (left==null){
             result=right;
             return result;
         }
         if (right==null){
             result=left;
             return result;
         }

         if (left.data<=right.data){
             result=left;
             result.next= merge(left.next, right);
         }
         else{
             result=right;
             result.next= merge(left, right.next);
         }

        return result;
    }

    public static void main(String[] args){

        ListSortingMergeSort.Push(15);
        ListSortingMergeSort.Push(10);
        ListSortingMergeSort.Push(5);
        ListSortingMergeSort.Push(20);
        ListSortingMergeSort.Push(3);
        ListSortingMergeSort.Push(2);
        head= ListSortingMergeSort.mergeSort(head);
        print(head);

    }

}
