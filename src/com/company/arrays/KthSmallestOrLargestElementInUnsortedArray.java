package com.company.arrays;

import java.util.Scanner;

public class KthSmallestOrLargestElementInUnsortedArray {

    private static int quickSelect(int[] array, int l , int h, int k){
        int pivotValue= array[h];
        int pivotIndex = partition(array, pivotValue, l, h);
        if (k>pivotIndex){
            return quickSelect(array, pivotIndex+1, h, k);
        }
        else if(k<pivotIndex){
            return quickSelect(array, l , pivotIndex-1, k);
        }
        else {
            return array[pivotIndex];
        }

    }

    private static int partition(int[] array, int pivotValue, int l, int h) {
        int i = l, j = l;
       while (j<= h){
           if (array[j]<=pivotValue){
               int temp = array[j];
               array[j]= array[i];
               array[i]= temp;
               i++;
               j++;
           }
           else{
               j++;
           }
       }
       return i-1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("No of Elements");
        int n = sc.nextInt();
        System.out.println("Enter All Elements");
        int [] array = new int[n];
        for(int i = 0 ; i < n; i++){
            array[i]= sc.nextInt();
        }
        System.out.println("Enter the kth index");
        int k = sc.nextInt() ;
        int value= quickSelect(array, 0, n-1, k-1);
        System.out.println("The kth min element is "+ value);
    }
}
