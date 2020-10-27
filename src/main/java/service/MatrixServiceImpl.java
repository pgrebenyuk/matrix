package service;

import entity.Matrix;
import user.InputManager;
import manager.MatrixManager;

public class MatrixServiceImpl implements MatrixService {
    private MatrixManager matrixManager;
    private InputManager matrixUser;


    public MatrixServiceImpl(MatrixManager matrixManager, InputManager matrixUser) {
        this.matrixManager = matrixManager;
        this.matrixUser = matrixUser;
    }

    @Override
    public void startMatrixShow() {
        int size = matrixUser.getMatrixSize();
        Matrix matrix = matrixManager.initializationMatrix(size);
        matrixManager.printMatrix(matrix);
        int totalCount = 0;
        int mixesCount = 0;
        do {
            if (mixesCount != 0) {
                for (var i = 0; i <= mixesCount; i++) {
                    matrix = matrixManager.mixMatrix(matrix);
                }
                matrixManager.printMatrix(matrix);
                totalCount += mixesCount;
                System.out.println("number of mixes: " + totalCount);
            }
            mixesCount = matrixUser.getMixesCount();
        } while (mixesCount != 0);
    }
}
