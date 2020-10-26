package service;

import entity.Matrix;
import repository.MatrixRepository;
import repository.MatrixRepositoryImpl;

import java.util.Scanner;

public class MatrixServiceImpl implements MatrixService {
    MatrixRepository matrixRepository = new MatrixRepositoryImpl();

    @Override
    public void startMatrixShow() {

        Scanner scan = new Scanner(System.in);
        int size = 0;
        while (size < 2) {
            System.out.println("Enter the length of the matrix ( > 1): ");
            size = scan.nextInt();
        }
        Matrix matrix = matrixRepository.initializationMatrix(size);
        matrixRepository.printMatrix(matrix);
        int numberAll = 0;
        System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
        int number = scan.nextInt();
        while (!(number == 0)) {
            for (int i = 0; i <= number; i++) {
                matrix = matrixRepository.mixMatrix(matrix);
            }
            matrixRepository.printMatrix(matrix);
            numberAll = numberAll + number;
            System.out.println("number of mixes: " + numberAll);
            System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
            number = scan.nextInt();
        }
    }
}
