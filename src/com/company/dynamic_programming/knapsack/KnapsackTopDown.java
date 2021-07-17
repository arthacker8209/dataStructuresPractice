package com.company.dynamic_programming.knapsack;

import com.company.dynamic_programming.knapsack.KnapsackMemoization;

public class KnapsackTopDown extends KnapsackMemoization {




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

        System.out.print(knapsackTopDown(val, wt, n, W, dp));
        System.out.println();

        for (int i =0; i<n+1; i++){
            for (int j= 0; j<W+1; j++){
                System.out.print(dp[i][j]+" ");
            }
              System.out.println();
        }
    }

    private static int knapsackTopDown(int[] val, int[] wt, int n, int w, int[][] dp) {
        int i , j ;
        for(i=0; i<=n; i++){
            for (j=0; j<=w; j++){
                if (i==0||j==0){
                    dp[i][j]=0;
                }
                else if (wt[i-1]<=w){
                    dp[i][j]= max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                }
                else {
                    dp[i][j]= dp[i-1][w];
                }
            }
        }
        return dp[n][w];
    }
}
