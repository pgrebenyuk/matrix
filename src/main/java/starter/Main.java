package starter;

import service.MatrixService;
import service.MatrixServiceImpl;

public class Main {

    public static void main(String[] args) {
        MatrixService matrixService = new MatrixServiceImpl();
        matrixService.startMatrixShow();
    }

}
