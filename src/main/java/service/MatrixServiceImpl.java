package service;

import User.MatrixUser;
import entity.Matrix;
import manager.MatrixManager;

public class MatrixServiceImpl implements MatrixService {
    private  MatrixManager matrixManager;
    private  MatrixUser matrixUser;


    public MatrixServiceImpl(MatrixManager matrixManager, MatrixUser matrixUser) {
        this.matrixManager = matrixManager;
        this.matrixUser = matrixUser;
    }

    @Override
    public void startMatrixShow() {
        int size = matrixUser.sizeMatrix();
        Matrix matrix = matrixManager.initializationMatrix(size);
        matrixManager.printMatrix(matrix);
        int numberAll = 0;
        int number = 0;
        do {
            if (number != 0) {
                for (int i = 0; i <= number; i++) {
                    matrix = matrixManager.mixMatrix(matrix);
                }
                matrixManager.printMatrix(matrix);
                numberAll += number;
                System.out.println("number of mixes: " + numberAll);
            }
            number = matrixUser.numberMixes();
        } while (number != 0);
    }
}
