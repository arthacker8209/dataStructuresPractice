package com.company.arrays;

public class MoveNegativeElements {

    private static int[] moveNegative(int[] nums, int l , int r){
      //-12, 11, -13, -5, 6, -7, 5, -3, -6
        //nums[l]= -12;
        //nums[r]=-6;
        while (l<r){

            if (nums[l]>0 && nums[r]<0){
                swap(nums,l, r );
            }
            else if (nums[l]<0)l++;
            else{r--;}
        }
        return nums;
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]= temp;
    }


    public static void main(String[] args){

        int[] array = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        array= moveNegative(array,0, array.length-1);
        for(int val : array){
            System.out.print(val+" ");
        }


    }
}
