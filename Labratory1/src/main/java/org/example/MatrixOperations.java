package org.example;
import java.util.Random;

class MatrixOperations {
    public Number[][] scalarMultiply(Number[][] matrix, int scalar) {
        int rows = matrix.length, cols = matrix[0].length;
        Number[][] result = new Number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j].doubleValue() * scalar;
            }
        }
        return result;
    }

    public Number[][] transposeMatrix(Number[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Number[][] result = new Number[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public Number[][] addMatrices(Number[][] A, Number[][] B) {
        int rows = A.length, cols = A[0].length;
        Number[][] result = new Number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j].doubleValue() + B[i][j].doubleValue();
            }
        }
        return result;
    }

    public Number[][] xorMatrices(Number[][] A, Number[][] B) {
        int rows = A.length, cols = A[0].length;
        Number[][] result = new Number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j].intValue() ^ B[i][j].intValue();
            }
        }
        return result;
    }

    public Number[][] multiplyMatrices(Number[][] A, Number[][] B) {
        int rows = A.length, cols = B[0].length;
        Number[][] result = new Number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = 0;
                for (int k = 0; k < A[0].length; k++) {
                    sum += A[i][k].doubleValue() * B[k][j].doubleValue();
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
