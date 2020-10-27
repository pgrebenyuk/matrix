package manager;

import entity.Atom;
import entity.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixManagerImpl implements MatrixManager {

    @Override
    public Matrix mixMatrix(Matrix matrix) {
        Atom[][] array = matrix.getMatrix();
        int length = array[0].length;
        int x = new Random().nextInt(length);
        int y = new Random().nextInt(length);
        //взагалі краще б рандомом займався окремий клас, який ти б визивав звідси
        //бо вдруг завтра правила рандома поміняються, чи взагалі не буде вже його
//        не  бачу сенсу. ми ж саме тут логіку встановлюємо, якщо зміни, то тут і робимо,
//        або наслідуємось і оверайдимо, чи новий клас імплиментимо від матріксМенеджера

        if (array[x][y] != Atom.HOLE) {
            for (int i = x == 0 ? 0 : x - 1; i < (x == length ? x : x + 1); i++) {
                for (int j = y == 0 ? 0 : y - 1; j < (y == length ? y : y + 1); j++) {
                    List<int[]> list = new ArrayList<>();
                    if (array[i][j] == Atom.HOLE && !((i == x) && (j == y))) {
                        list.add(new int[] {i, j});
                    }
                    if (list.size() > 0) {
                        int index = new Random().nextInt(list.size());
                        array[list.get(index)[0]][list.get(index)[1]] = array[x][y];
                        array[x][y] = Atom.HOLE;
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    @Override
    public Matrix initializationMatrix(int size) {
        Atom[][] array = new Atom[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    array[i][j] = (j > (size / 2)) ? Atom.BLACK : Atom.BLUE;
                } else {
                    array[i][j] = Atom.HOLE;
                }
            }
        }
        Matrix matrix = new Matrix(size);
        matrix.setMatrix(array);
        return matrix;
    }

    @Override
    public void printMatrix(Matrix matrix) {
        Atom[][] array = matrix.getMatrix();
        int length = array[0].length;
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

}
