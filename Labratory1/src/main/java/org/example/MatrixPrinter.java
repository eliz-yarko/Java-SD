package org.example;
import java.util.Arrays;

class MatrixPrinter {
    public static void printMatrix(Object[][] matrix) {
        for (Object[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

