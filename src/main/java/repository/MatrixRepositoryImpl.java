package repository;

import entity.Matrix;

import java.util.Random;

public class MatrixRepositoryImpl implements MatrixRepository {
    private static final String[] ELEMENT = {"дірка", "ч_атом", "с_атом"};

    @Override
    public Matrix mixMatrix(Matrix matrix) {
        int[][] array = matrix.getMatrix();
        int length = array[0].length;
        int x =  (int) (Math.random() * length);
        int y = (int) (Math.random() * length);

        if (array[x][y] > 0) {
            for (int i = x == 0 ? 0 : x - 1; i < (x == length ? x : x + 1); i++) {
                for (int j = y == 0 ? 0 : y - 1; j < (y == length ? y : y + 1); j++) {
                    if (array[i][j] == 0) {
                        array[i][j] = array[x][y];
                        array[x][y] = 0;
                        matrix.setMatrix(array);
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    @Override
    public Matrix initializationMatrix(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Random random = new Random();
                if ((random.nextInt(2)) == 0) {
                    array[i][j] = 1 + (j / (size / 2));
                }
            }
        }
        Matrix matrix = new Matrix(size);
        matrix.setMatrix(array);
        return matrix;
    }

    @Override
    public void printMatrix(Matrix matrix) {
        int[][] array = matrix.getMatrix();
        int length = array[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(ELEMENT[array[i][j]] + " ");
            }
            System.out.println();
        }
    }

}
