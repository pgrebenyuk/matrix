package entity;

public class Matrix {
    private Atom[][] matrix;

    //в цьому немає сенсу
    //в конструкторі ти ініціалізуєш пустий масив
    //а потім сетом в ту ссилку записуєш інший масив
    //тобі достатньо просто записувати масив і все
    //подумай про ссилки
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

