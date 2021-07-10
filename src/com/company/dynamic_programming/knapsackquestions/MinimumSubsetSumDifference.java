package com.company.dynamic_programming.knapsackquestions;

public class MinimumSubsetSumDifference {

    private static int difference(int[] array){
        int n = array.length;
        int sum=0;
        for(int i =0; i<n;i++){
            sum=sum+array[i];
        }

        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i =0; i<=n; i++){
            for (int j =0; j<=sum; j++){
                if (j==0){
                    dp[i][j]= true;
                }
                else if (i==0){
                    dp[i][j]= false;
                }
               else  if (array[i-1]>j)dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-array[i-1]];

                }
            }
        }

        int diff=Integer.MAX_VALUE;
        for (int i =0 ; i<=sum/2; i++){
                int first= i;
                int second= sum-i;
                if (dp[n][i] && diff>Math.abs(first-second)){
                    diff= Math.abs(first-second);
                }

        }

        return diff;
    }


    public static void main(String[] args){
        int[] array = {2,4,2,3};
        int ans= difference(array);
        System.out.println(ans);

    }
}
