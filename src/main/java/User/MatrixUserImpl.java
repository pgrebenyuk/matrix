package User;

import java.util.Scanner;

public class MatrixUserImpl implements MatrixUser{
    Scanner scan;

    public MatrixUserImpl() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public int sizeMatrix() {
        int size = 0;
        while (size < 2) {
            System.out.println("Enter the length of the matrix ( > 1): ");
            size = scan.nextInt();
        }
        return size;
    }

    @Override
    public int numberMixes() {
        int number;
        do {
            System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
            number = scan.nextInt();
        } while (number < 0);
        return number;
    }

}
