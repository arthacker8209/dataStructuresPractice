package com.company.dynamic_programming.knapsackquestions;

public class CountSubsetsWithGivenSum {

    private static int countSubsetsWithGivenSum(int[] array, int n , int sum, int[][] dp){
      int i,j;
        for (i =0; i< dp.length; i++){
            for (j=0;j<dp[0].length; j++){
                if (i==0&&j==0)dp[i][j]=1;
                else if (i==0)dp[i][j]=0;
                else if (j==0)dp[i][j]=1;
                else {
                    if (array[i-1]>j)
                        dp[i][j]=dp[i-1][j];
                    else{
                        dp[i][j]= dp[i-1][j] + dp[i-1][j-array[i-1]];
                    }
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args){
        int[] array = {2,3,5,6,8,10};
        int sum =10;
        int n = array.length;
        int[][] dp =new int[n+1][sum+1];
        int result = countSubsetsWithGivenSum(array,n,sum,dp);
        System.out.println(result);
    }
}
