package manager;

import entity.Atom;
import entity.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixManagerImpl implements MatrixManager {

    class Index {
        private int indexI;
        private int indexJ;

        public Index(int indexI, int indexJ) {
            this.indexI = indexI;
            this.indexJ = indexJ;
        }

        public int getIndexI() {
            return indexI;
        }

        public int getIndexJ() {
            return indexJ;
        }
    }

    @Override
    public Matrix mixMatrix(Matrix matrix) {
        var array = matrix.getMatrix();
        var length = array[0].length;
        var x = new Random().nextInt(length);
        var y = new Random().nextInt(length);

        if (array[x][y] != Atom.HOLE) {
            for (int i = x == 0 ? 0 : x - 1; i < (x == length ? x : x + 1); i++) {
                for (int j = y == 0 ? 0 : y - 1; j < (y == length ? y : y + 1); j++) {
                    List<Index> list = new ArrayList<>();
                    if (i != x && j != y) {
                        if (array[i][j] == Atom.HOLE) {
                            list.add(new Index(i, j));
                        }
                    }

                    if (list.size() > 0) {
                        int indexRandom = new Random().nextInt(list.size());
                        array[list.get(indexRandom).getIndexI()][list.get(indexRandom).getIndexJ()] = array[x][y];
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
        //короче сенс цієї можливості var зводиться не до того, щоб все писати як вар
        //точніше так можна писати, але тоді падає читабельність коду
        var array = new Atom[size][size];
        //не використовуй вар всюди
        //використовуй в форічах і там, де зразу буде зрозуміло, який це тип даних
        //от тут я не розумію зараз чи і це int, чи long, чи ще щось
        //короче краще поки взагалі це слово рідко використовувати
        for (var i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //псує читабельність
                var random = new Random();
                if (random.nextBoolean()) {
                    array[i][j] = (j > (size / 2)) ? Atom.BLACK : Atom.BLUE;
                } else {
                    array[i][j] = Atom.HOLE;
                }
            }
        }
        return new Matrix(array);
    }

    @Override
    public void printMatrix(Matrix matrix) {
        Atom[][] array = matrix.getMatrix();
        for (var arr : array) {
            System.out.println(Arrays.toString(Arrays.stream(arr).map(Atom::getNumber).toArray()));
        }
    }

}
