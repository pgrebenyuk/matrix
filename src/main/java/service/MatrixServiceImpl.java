package service;

import entity.Matrix;
import repository.MatrixRepository;
import repository.MatrixRepositoryImpl;

import java.util.Scanner;

public class MatrixServiceImpl implements MatrixService {
    //немає модифікатора
    //плюс краще ініціалізувати поле в конструкторі, щоб хтось міг свій репозиторій передати
    MatrixRepository matrixRepository = new MatrixRepositoryImpl();

    @Override
    public void startMatrixShow() {

        //тут цей ввід довжини непогано б в окремий метод
        //а ще краще в окремий клас(зараз наприклад юзер задає, а можна і захардкодити самим, чи зчитати з файлу)
        Scanner scan = new Scanner(System.in);
        int size = 0;
        while (size < 2) {
            System.out.println("Enter the length of the matrix ( > 1): ");
            size = scan.nextInt();
        }
        //тут супер все
        Matrix matrix = matrixRepository.initializationMatrix(size);
        matrixRepository.printMatrix(matrix);
        int numberAll = 0;
        //цю частину коду також можна зробити змінною
        //зараз вона задається юзером, а завтра я захочу зчитувати стрічки файла, аж поки не знайдеш 0
        //краще це вивести ще в 1 клас, який буде казати, чи ще будуть мішати матрицю і якщо так, то скільки раз
        //ця штука дублюється, треба щоб вона була тільки в вайлі
        System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
        int number = scan.nextInt();
        //це пишеться тако number != 0
        while (!(number == 0)) {
            for (int i = 0; i <= number; i++) {
                matrix = matrixRepository.mixMatrix(matrix);
            }
            matrixRepository.printMatrix(matrix);
            //це ще можна записати так numberALL += number;
            numberAll = numberAll + number;
            System.out.println("number of mixes: " + numberAll);
            System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
            number = scan.nextInt();
        }
    }
}
