package com.java.ee.bug_fix.null_pointer_exceptions;

public class ArrayTest2 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
            }
        }

        //implements yours output according to the next style
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < i + 1; j++) {
                System.out.print(matrix[i][j]);
                if (j != i)
                    System.out.print(", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
/*
[1]
[1, 1]
[1, 1, 1]
[1, 1, 1, 1]
[1, 1, 1, 1, 1]
 */