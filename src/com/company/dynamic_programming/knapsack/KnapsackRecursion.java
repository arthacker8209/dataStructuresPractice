package com.company.dynamic_programming.knapsack;

public class KnapsackRecursion {

    private static int max(int a, int b){
        //same as math utility function Math.max
        return (a>b)?a:b;
    }

    private static int knapsackRecursion(int[] val, int[] wt , int n , int W ){
        //base condition
        if (n==0|| W==0)return 0;
        if (W< wt[n-1]){
           return knapsackRecursion(val,wt, n-1, W);
        }
        else {
            return max( val[n-1] + knapsackRecursion(val,wt ,n-1, W-wt[n-1]),
                    knapsackRecursion(val,wt, n-1, W));
        }
    }



    public static void main(String[] args){
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsackRecursion(val, wt, n, W));
    }
}
