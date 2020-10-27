package entity;

public class Matrix {
    private Atom[][] matrix;

    public Matrix(int size) {
        if (size > 0) {
            matrix = new Atom[size][size];
        }
    }

    public Atom[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Atom[][] matrix) {
        this.matrix = matrix;
    }
}

