package starter;

import User.UserInputManager;
import manager.MatrixManagerImpl;
import service.MatrixService;
import service.MatrixServiceImpl;

public class Main {

    public static void main(String[] args) {
        //тут трошки не так це пишеться, першу дужку треба лишити в цьому рядку
        MatrixService matrixService = new MatrixServiceImpl(
                new MatrixManagerImpl(), new UserInputManager());
        matrixService.startMatrixShow();
    }

}
