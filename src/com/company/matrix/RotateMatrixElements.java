package com.company.matrix;

public class RotateMatrixElements {

    private static int[][] rotate(int[][] matrix, int m , int n){
        int row= 0;
        int col= 0;
        int prev ;
        int curr;

        while (row<m && col<n){

            prev=matrix[row+1][col];
            for (int i =0 ; i<n; i++){
                curr= matrix[row][i];
                matrix[row][i]= prev;
                prev= curr;
            }
            row++;

            for (int i =row; i<m ; i++){
                curr = matrix[i][n-1];
                matrix[i][n-1]= prev;
                prev= curr;
            }
            n--;

            if (row<m){
                for (int i = n-1; i>=col; i--){
                    curr=matrix[m-1][i];
                    matrix[m-1][i]= prev;
                    prev= curr;
                }
            }
            m--;

            if (col<n){
                for (int i = m-1; i>=row; i--) {
                    curr = matrix[i][col];
                    matrix[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }

        return matrix;
    }

    private static void  print(int[][] matrix){
        for (int i =0 ; i<matrix.length; i++){
            for (int j =0 ; j< matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){

        int[][] a = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} };


        System.out.println("Old Matix");
        System.out.println();

        for (int i =0 ; i<a.length; i++){
            for (int j =0 ; j< a[0].length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        int[][] matrix = rotate(a, a.length, a[0].length);
        System.out.println();
        print(matrix);
    }
}
