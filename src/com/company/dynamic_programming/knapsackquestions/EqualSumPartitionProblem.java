package com.company.dynamic_programming.knapsackquestions;

public class EqualSumPartitionProblem {

   private static boolean isSubsetSum( int[] array,int n,int sum,boolean[][] dp){
       int i,j;
       for(i=0;i<dp.length;i++){
           for (j=0; j<dp[0].length; j++){
               if (i==0&&j==0)dp[i][j]=true;
               else if (i==0)dp[i][j]=false;
               else if (j==0)dp[i][j]=true;
               else {
                   if (dp[i-1][j])dp[i][j]=true;
                   else {
                       int val = array[i-1];
                       if (val<=j){
                           if (dp[i-1][j-val])dp[i][j]=true;
                           else {
                               dp[i][j]=false;
                           }
                       }
                   }
               }
           }


       }
       return dp[n][sum];
   }













    public static void main(String[] args){
        int[] array= {1,5,11,5,1};
        int n = array.length;
        int sum=0;
        boolean result;
        for (int i =0; i<n;i++){
            sum=sum+array[i];
        }
        if (sum%2!=0){
            System.out.println(false);
        }
        else {
            sum=sum/2;
            boolean[][] dp = new boolean[n+1][sum+1];
           result= isSubsetSum(array,n,sum,dp);
            System.out.println(result);
        }


    }

}
