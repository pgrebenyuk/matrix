package service;

import User.MatrixUser;
import entity.Matrix;
import manager.MatrixManager;

public class MatrixServiceImpl implements MatrixService {
    //чогось по 2 пробіли
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
        //totalCount
        int numberAll = 0;
        //mixesCount
        int number = 0;
        do {
            if (number != 0) {
                for (int i = 0; i <= number; i++) {
                    matrix = matrixManager.mixMatrix(matrix);
                }
                matrixManager.printMatrix(matrix);
                numberAll += number;
                //number - це число, count - це кількість
                System.out.println("number of mixes: " + numberAll);
            }
            number = matrixUser.numberMixes();
        } while (number != 0);
    }
}
