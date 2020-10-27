package starter;

import user.UserInputManager;
import manager.MatrixManagerImpl;
import service.MatrixService;
import service.MatrixServiceImpl;

public class Main {

    public static void main(String[] args) {
        MatrixService matrixService = new MatrixServiceImpl(new MatrixManagerImpl(),
                new UserInputManager());
        matrixService.startMatrixShow();
    }

}
