package entity;

public class Matrix {
    private Atom[][] matrix;

    public Atom[][] getMatrix() {
        return matrix;
    }

    //краще вже просто конструктор зробити, який приймає матрицю
    public void setMatrix(Atom[][] matrix) {
        this.matrix = matrix;
    }
}

