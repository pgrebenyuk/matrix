package starter;

import manager.RandomManager;
import user.UserInputManager;
import manager.MatrixManagerImpl;
import service.MatrixService;
import service.MatrixServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MatrixService matrixService = new MatrixServiceImpl(new MatrixManagerImpl(new RandomManager()),
                new UserInputManager(new Scanner(System.in)));
        matrixService.startMatrixShow();
    }

}
