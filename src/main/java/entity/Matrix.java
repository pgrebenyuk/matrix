package entity;

public class Matrix {
    private int[][] matrix;

    //не використовується
    public Matrix() {

    }

    public Matrix(int size) {
        if (size > 0) {
            matrix = new int[size][size];
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
