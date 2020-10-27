package manager;

import entity.Matrix;

public interface MatrixManager {
    Matrix mixMatrix(Matrix matrix);
    Matrix initializationMatrix(int size);
    void printMatrix(Matrix matrix);
}
