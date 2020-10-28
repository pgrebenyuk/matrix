package user;

import java.util.Scanner;

public class UserInputManager implements InputManager {
    private static final int MIN_SIZE_MATRIX = 2;
    private final Scanner scan;

    //на ділі ж передавати такий клас як параметр в конструктор немає сенсу
    //в нас це просто для тесту
    //в реальному проекті це просто не буде теститись
    public UserInputManager(Scanner scan) {
        this.scan = scan;
    }

    @Override
    public int getMatrixSize() {
        int size = 0;
        while (size < MIN_SIZE_MATRIX) {
            System.out.println("Enter the length of the matrix ( > 1): ");
            size = scan.nextInt();
        }
        return size;
    }

    @Override
    public int getMixesCount() {
        int mixesCount;
        do {
            System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
            mixesCount = scan.nextInt();
        } while (mixesCount < 0);
        return mixesCount;
    }

}
