package com.company.sorting;

import java.util.Scanner;

public class QuickSort {

    private static int partition(int[] array, int l, int r){
        int pivotValue= array[l];
        int i =l;
        int j = r;
        while(i<j){
            while (array[i]<=pivotValue)i++;
            while (array[j]>pivotValue)j--;
            if (i<j){
                swap(array,i,j);
            }

        }
        swap(array,j,l);
        return j;
    }


    private static void quickSort(int[] array, int l , int r){
        if(l<r){
            int pivot = partition(array, l, r);
            quickSort(array, l, pivot-1);
            quickSort(array, pivot+1,r);
        }
    }


    private static void swap(int[] array, int i, int j) {
        int temp= array[i];
        array[i]= array[j];
        array[j]= temp;
    }

    private static void printArray(int[] array) {
        for(int value: array) {
            System.out.print(value+" ");
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array Elements");
        for (int i = 0 ; i<n; i++){
            array[i]=sc.nextInt();
        }
        quickSort(array,0, array.length-1);
        printArray(array);
    }



}

