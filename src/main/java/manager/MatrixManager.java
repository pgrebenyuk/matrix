package manager;

import entity.Matrix;

public interface MatrixManager {
    //куча відсупів непотрібних

    Matrix mixMatrix(Matrix matrix);
    Matrix initializationMatrix(int size);
    void printMatrix(Matrix matrix);
}
