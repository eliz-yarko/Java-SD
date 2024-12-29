package org.example;

import java.util.Random;

class MatrixGenerator {
    public Number[][] generateNumberMatrix(int rows, int cols, int type) {
        Random rand = new Random();
        Number[][] matrix = new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = switch (type) {
                    case 0 -> rand.nextDouble() * 10;
                    case 1 -> (byte) rand.nextInt(10);
                    case 2 -> (short) rand.nextInt(10);
                    case 3 -> rand.nextInt(10);
                    case 4 -> rand.nextLong(10);
                    case 6 -> rand.nextFloat() * 10;
                    default -> 0;
                };
            }
        }
        return matrix;
    }
}
