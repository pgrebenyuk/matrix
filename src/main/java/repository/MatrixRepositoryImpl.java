package repository;

import entity.Matrix;

import java.util.Arrays;
import java.util.Random;

//назва погана
//репозиторій це той хто має справу з якимись хранилищами даних, в тебе ж цього немає
//ти можеш використовувати тут любу назву, яка тобі здається підходящою
//в даний момент цей клас робить дії над матрицею, якось так і назвати треба
public class MatrixRepositoryImpl implements MatrixRepository {
    //це не енум, а я просив енум, переробити !!!
    private static final String[] ELEMENT = {"дірка", "ч_атом", "с_атом"};

    @Override
    public Matrix mixMatrix(Matrix matrix) {
        int[][] array = matrix.getMatrix();
        int length = array[0].length;
        //можна і так new Random().nextInt(length);
        int x =  (int) (Math.random() * length);
        int y = (int) (Math.random() * length);
        //взагалі краще б рандомом займався окремий клас, який ти б визивав звідси
        //бо вдруг завтра правила рандома поміняються, чи взагалі не буде вже його

        if (array[x][y] > 0) {
            //цей цикл дуже круто написав, класні умови
            for (int i = x == 0 ? 0 : x - 1; i < (x == length ? x : x + 1); i++) {
                for (int j = y == 0 ? 0 : y - 1; j < (y == length ? y : y + 1); j++) {
                    if (array[i][j] == 0) {
                        //але тут я ще просив дещо
                        //є  можливих сусідів і перейти ти маєш в рандомний, а не в перший!!!
                        array[i][j] = array[x][y];
                        array[x][y] = 0;
                        //по ідеї ти array і так витягнув з об*єкта matrix
                        //і все що ти тут міняв відобразиться в об*єкті
                        //можна не запихати ерей назад, він і так буде оновлений
                        //хоча перевір)
                        matrix.setMatrix(array);
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    @Override
    public Matrix initializationMatrix(int size) {
        //хай буде масив не інтів, а енума твого, який ти створиш
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Random random = new Random();
                //це ще можна зробити так
                //random.nextBoolean()
                if ((random.nextInt(2)) == 0) {
                    //тут все круто, але я як чужий кодер, не розумію що таке 1, а що 2
                    array[i][j] = 1 + (j / (size / 2));
                }
            }
        }
        Matrix matrix = new Matrix(size);
        matrix.setMatrix(array);
        return matrix;
    }

    @Override
    public void printMatrix(Matrix matrix) {
        int[][] array = matrix.getMatrix();
        int length = array[0].length;
        //є такий метод для прінта 2 вимірної матриці, він пише всю матрицю
        //Arrays.deepToString(array);
        for (int i = 0; i < length; i++) {
            //а є такий метод для прінта 1 рявимірної матриці, він пише всю матрицю
            //Arrays.toString(array);
            //можеш перевірити, вдруг тобі якийсь з них більше підходить
            for (int j = 0; j < length; j++) {
                //все таки хочу енум, це щось новеньке буде
                System.out.print(ELEMENT[array[i][j]] + " ");
            }
            System.out.println();
        }
    }

}
