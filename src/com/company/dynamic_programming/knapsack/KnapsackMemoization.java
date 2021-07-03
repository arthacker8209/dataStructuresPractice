package com.company.dynamic_programming.knapsack;

public class KnapsackMemoization {

    protected static int max(int a, int b){
        return (a>b)?a:b;
    }

    private static int knapsackMemoization(int[] val , int[] wt, int n , int W, int[][] dp){
        if (n==0||W==0)return 0;

        if (dp[n][W]!=0){
            return dp[n][W];
        }
        if (W<wt[n-1]){
            return dp[n][W]= knapsackMemoization(val,wt, n-1, W, dp);
        }
        else {
            return dp[n][W]= max( val[n-1] + knapsackMemoization(val,wt ,n-1, W-wt[n-1],dp),
                    knapsackMemoization(val,wt, n-1, W,dp));
        }
    }
    public static void main(String[] args){


            int val[] = { 6, 1,12};
            int wt[] = { 1, 2, 3 };

            int W = 5;
            int n = val.length;

            int[][] dp = new int[n+1][W+1];
            for (int i =0; i<n+1; i++){
                for (int j= 0; j<W+1; j++){
                    if (i==0&& j==0){
                        dp[i][j]=0;
                    }

                }
            }

            System.out.print(knapsackMemoization(val, wt, n, W, dp));
            System.out.println();

            for (int i =0; i<n+1; i++){
                for (int j= 0; j<W+1; j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
    }
}
