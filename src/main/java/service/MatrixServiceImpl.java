package service;

//папки називають з маленької букви
import User.InputManager;
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
        var size = matrixUser.getMatrixSize();
        var matrix = matrixManager.initializationMatrix(size);
        matrixManager.printMatrix(matrix);
        var totalCount = 0;
        var mixesCount = 0;
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
