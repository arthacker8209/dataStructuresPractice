package com.company.linkedlist;


public class ListSortingQuickSort {
    static class Node{
        int data ;
        Node next;
        Node(int data){
            this.data= data;
        }
    }

    private static Node head= null;


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

    private static Node partition(Node start , Node end){
        if (start==end|| start==null|| end==null){
            return start;
        }
        Node prev_node= start;
        Node current= start;
        int pivot = end.data;

        while (start!=end){
            if (start.data<pivot){
            prev_node=current;
            int temp= current.data;
            current.data= start.data;
            start.data= temp;
            current= current.next;
            }
            start= start.next;
        }

        int temp = current.data;
        current.data= pivot;
        end.data=temp;
        return prev_node;
    }

    private static void listQuickSort(Node start, Node end){
            if (start==null|| start==end|| start== end.next)return;

        Node pivot_prev = partition(start, end);
        listQuickSort(start,pivot_prev);

        if(pivot_prev!=null&& pivot_prev==start){
        listQuickSort(pivot_prev.next,end);}

        else if (pivot_prev!=null && pivot_prev.next!=null){
            listQuickSort(pivot_prev.next.next,end);
        }

    }

    public static void main(String[] args){

        ListSortingQuickSort.Push(11);
        ListSortingQuickSort.Push(19);
        ListSortingQuickSort.Push(4);
        ListSortingQuickSort.Push(7);
        ListSortingQuickSort.Push(5);
        ListSortingQuickSort.Push(3);
        ListSortingQuickSort.Push(12);

        Node current= head;
        while (current.next!=null){
            current=current.next;
        }

        System.out.println("Linked List before sorting");
        print(head);
        ListSortingQuickSort.listQuickSort(head,current);
        System.out.println("\nLinked List after sorting");
        print(head);
    }
}
