package com.company.arrays;
import java.util.*;

public class Union {

    private static int[] unionOfTwoArrays(int[] a1, int[] a2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : a1) {
            map.put(value, map.getOrDefault(map.get(value), 1) + 1);
        }
        for (int value : a2) {
            map.put(value, map.getOrDefault(map.get(value), 1) + 1);
        }

        int[] array =new int[map.size()];
        int i =0;
      for (int entry: map.keySet()){
          array[i]= entry;
          i++;
      }

        return array;
    }


    private static Set<Integer> intersectionOfTwoArrays(int[] a1, int[] a2){
      Set<Integer> result = new HashSet<>();
      int i =0 ,  j=0;

      while (i<a1.length && j<a2.length){
          if (a1[i]==a2[j]){
              result.add(a1[i]);
              i++;
              j++;
          }
          else {
              i++;
              j++;
          }
      }
      return result;
    }

//    private static int[] withoutHashMap(int[] a1 , int[] a2){
//        int[] result = new int[a1.length+a2.length];
//        int i=0 , j=0;
//        int k =0;
//        while (i<a1.length && j<a2.length){
//            if (a1[i]!=a2[j]){
//                result[k]= a1[i];
//                k++;
//                result[k]= a2[j];
//                k++;
//                j++;
//                i++;
//            }
//            else {
//                result[k]=a1[i];
//                k++;
//                i++;
//                j++;
//            }
//        }
//
//        while (i<a1.length){
//            result[k]= a1[i];
//            k++;
//            i++;
//        }
//        while (j<a2.length){
//            result[k]= a2[j];
//            k++;
//            j++;
//        }
//        return result;
//    }


    public static void main(String[] args){
int[] array1 ={1 ,2 ,3 ,4 ,5};
int[] array2 = {1,2,3,7,8,9,1};

Set<Integer> set = intersectionOfTwoArrays(array1, array2);
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    int[] result = unionOfTwoArrays(array1, array2);
   // int[] result2 = withoutHashMap(array1,array2);

//    for (int val : result){
//        System.out.print(val+" ");
//    }
    }
}
