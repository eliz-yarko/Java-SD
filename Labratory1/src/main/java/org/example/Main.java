package org.example;

public class Main {
    public static void main(String[] args) {
        // Введення номера залікової книжки
        int studentID = 23 * 100 + 24; // Група 23, номер у групі 24

        // Обчислення C5, C7, C11
        int C5 = studentID % 5;
        int C7 = studentID % 7;
        int C11 = studentID % 11;

        // Визначення розміру матриць
        int rows = 4;
        int cols = 4;

        // Генерація матриць
        MatrixGenerator generator = new MatrixGenerator();
        Number[][] A = generator.generateNumberMatrix(rows, cols, C7);
        Number[][] B = generator.generateNumberMatrix(rows, cols, C7);

        Object[][] C = null;

        // Перша дія з матрицями відповідно до C5
        MatrixOperations operations = new MatrixOperations();
        switch (C5) {
            case 0 -> C = operations.scalarMultiply(A, 2);
            case 1 -> C = operations.transposeMatrix(A);
            case 2 -> C = operations.addMatrices(A, B);
            case 3 -> C = operations.xorMatrices(A, B);
            case 4 -> C = operations.multiplyMatrices(A, B);
        }

        // Вивід результату першої дії
        System.out.println("Initial Matrix A:");
        MatrixPrinter.printMatrix(A);
        System.out.println("Matrix B:");
        MatrixPrinter.printMatrix(B);
        System.out.println("Resulting Matrix C:");
        MatrixPrinter.printMatrix(C);

        // Друга дія з матрицею відповідно до C11
        MatrixProcessor processor = new MatrixProcessor();
        double result = processor.processMatrix((Number[][]) C, C11);
        System.out.println("Result of processing C: " + result);
    }
}
