package com.company.sorting;

import java.util.Scanner;

public class MergeSort {
    private static void mergeSort(int[] array, int l, int r) {
        if (l<r){
            int mid = l+(r-l)/2;
            mergeSort(array,l,mid);
            mergeSort(array,mid+1,r);
            merge(array,l,mid,r);
            
        }
    }

    private static void merge(int[] array, int l, int mid, int r) {
        int n= mid-l+1;
        int m = r-mid;

        int[] L= new int[n];
        int[] R= new int[m];
        for(int i =0; i<n;i++){
            L[i]=array[l+i];
        }
        for(int j =0; j<m;j++){
            R[j]=array[mid+1+j];
        }
        int i =0, j=0;
        int k =l;
        while (i<n&&j<m){
            if (L[i]<R[j]){
                array[k]=L[i];
                i++;
            }
            else{
                array[k]=R[j];
                j++;
            }
            k++;
        }
        while (i<n){
            array[k]=L[i];
            i++;
            k++;
        }
        while (j<m){
            array[k]=R[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0 ; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
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
        mergeSort(array,0, array.length-1);
        printArray(array);
    }


}
