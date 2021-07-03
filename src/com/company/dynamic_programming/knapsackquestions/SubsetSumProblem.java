package com.company.dynamic_programming.knapsackquestions;

public class SubsetSumProblem {

    private static boolean isSubsetSum( int[] array,int n,int sum,boolean[][] dp){
        int i;
        int j;
        for (i=0;i<dp.length;i++ ){
            for (j=0;j<dp[0].length;j++){
                if (i==0 && j==0)dp[i][j]=true;
                else if (i==0)dp[i][j]=false;
                else if (j==0)dp[i][j]= true;
                else {
                    if (dp[i-1][j])dp[i][j]=true;
                    else {
                        int val = array[i-1];
                        if (val<=j){
                            if (dp[i-1][j-val]){
                                 dp[i][j]=true;
                            }
                            else dp[i][j]=false;
                        }

                    }
                }
            }
        }


        return dp[n][sum];
    }



    public static void main(String[] args){
            int[] array = {3, 34, 4, 12, 5, 2};
            int sum= 9;
            int n = array.length;
            boolean[][]  dp = new boolean[n+1][sum+1];
            boolean result= isSubsetSum(array,n,sum,dp);
            System.out.println(result);
    }
}
