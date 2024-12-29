package org.example;

class MatrixProcessor {
    public double processMatrix(Number[][] matrix, int C11) {
        int rows = matrix.length, cols = matrix[0].length;
        double sum = 0;
        switch (C11) {
            case 0 -> { // Сума мінімумів по стовпцях
                for (int j = 0; j < cols; j++) {
                    double min = Double.MAX_VALUE;
                    for (int i = 0; i < rows; i++) {
                        min = Math.min(min, matrix[i][j].doubleValue());
                    }
                    sum += min;
                }
            }
            case 1 -> { // Сума мінімумів по рядках
                for (int i = 0; i < rows; i++) {
                    double min = Double.MAX_VALUE;
                    for (int j = 0; j < cols; j++) {
                        min = Math.min(min, matrix[i][j].doubleValue());
                    }
                    sum += min;
                }
            }
            case 2 -> { // Сума максимумів по стовпцях
                for (int j = 0; j < cols; j++) {
                    double max = Double.MIN_VALUE;
                    for (int i = 0; i < rows; i++) {
                        max = Math.max(max, matrix[i][j].doubleValue());
                    }
                    sum += max;
                }
            }
            case 3 -> { // Сума максимумів по рядках
                for (int i = 0; i < rows; i++) {
                    double max = Double.MIN_VALUE;
                    for (int j = 0; j < cols; j++) {
                        max = Math.max(max, matrix[i][j].doubleValue());
                    }
                    sum += max;
                }
            }
            case 4 -> { // Макс в парних рядках + мін в непарних
                for (int i = 0; i < rows; i++) {
                    double val = (i % 2 == 0) ? Double.MIN_VALUE : Double.MAX_VALUE;
                    for (int j = 0; j < cols; j++) {
                        if (i % 2 == 0) {
                            val = Math.max(val, matrix[i][j].doubleValue());
                        } else {
                            val = Math.min(val, matrix[i][j].doubleValue());
                        }
                    }
                    sum += val;
                }
            }
            case 5 -> { // Макс в непарних рядках + мін в парних
                for (int i = 0; i < rows; i++) {
                    double val = (i % 2 != 0) ? Double.MIN_VALUE : Double.MAX_VALUE;
                    for (int j = 0; j < cols; j++) {
                        if (i % 2 != 0) {
                            val = Math.max(val, matrix[i][j].doubleValue());
                        } else {
                            val = Math.min(val, matrix[i][j].doubleValue());
                        }
                    }
                    sum += val;
                }
            }
            case 8 -> { // Середнє значення по рядках
                for (int i = 0; i < rows; i++) {
                    double rowSum = 0;
                    for (int j = 0; j < cols; j++) {
                        rowSum += matrix[i][j].doubleValue();
                    }
                    sum += rowSum / cols;
                }
            }
            case 9 -> { // Середнє значення по стовпцях
                for (int j = 0; j < cols; j++) {
                    double colSum = 0;
                    for (int i = 0; i < rows; i++) {
                        colSum += matrix[i][j].doubleValue();
                    }
                    sum += colSum / rows;
                }
            }
            case 10 -> { // Середнє значення для всієї матриці
                double totalSum = 0;
                int count = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        totalSum += matrix[i][j].doubleValue();
                        count++;
                    }
                }
                sum = totalSum / count;
            }
        }
        return sum;
    }
}
