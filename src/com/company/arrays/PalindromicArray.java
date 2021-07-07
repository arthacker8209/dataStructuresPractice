package com.company.arrays;

public class PalindromicArray {

    private static boolean isPalindrome(int n){
        String s =""+n;
        int len = s.length();
        for(int i=0; i<len/2;i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args){
        int[] array ={112,222,333,4444,121,1221};
        boolean ispal=true;
        for (int i =0; i< array.length; i++){
            ispal= isPalindrome(array[i]);
            if (!ispal){
                System.out.println(false);
                break;
            }
        }
        if (ispal) {
            System.out.println(ispal);
        }
    }
}
