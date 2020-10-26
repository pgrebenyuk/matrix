package repository;

import entity.Matrix;

public interface MatrixRepository {
    Matrix mixMatrix(Matrix matrix);
    Matrix initializationMatrix(int size);
    void printMatrix(Matrix matrix);
}
