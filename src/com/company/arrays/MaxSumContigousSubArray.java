package com.company.arrays;

import org.w3c.dom.ls.LSOutput;

public class MaxSumContigousSubArray {

    private static int maxSumContigousSubArray(int[] array) {
        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;

        for(int i =0; i<array.length; i++){
            max_end_here=max_end_here+array[i];
           max_so_far= Math.max(max_so_far,max_end_here);
            if (max_end_here<0){
                max_end_here=0;
            }
        }
        return max_so_far;
    }


    public static void main(String[] args){
        int[] array = {-2,-3,4,-1,-2,1,5,-3};
        int max= maxSumContigousSubArray(array);
        System.out.println(max);
    }
}
