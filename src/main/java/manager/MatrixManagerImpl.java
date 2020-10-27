package manager;

import entity.Atom;
import entity.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static entity.Atom.*;

public class MatrixManagerImpl implements MatrixManager {
    private static final int MIN_SIZE_MATRIX = 2;

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
        Atom[][] array = matrix.getMatrix();
        int length = array[0].length;
        int x = new Random().nextInt(length);
        int y = new Random().nextInt(length);

        if (array[x][y] != HOLE) {
            for (int i = x == 0 ? 0 : x - 1; i < (x == length ? x : x + 1); i++) {
                for (int j = y == 0 ? 0 : y - 1; j < (y == length ? y : y + 1); j++) {
                    List<Index> list = new ArrayList<>();
                    if (i != x && j != y) {
                        if (array[i][j] == HOLE) {
                            list.add(new Index(i, j));
                        }
                    }

                    if (list.size() > 0) {
                        int indexRandom = new Random().nextInt(list.size());
                        array[list.get(indexRandom).getIndexI()][list.get(indexRandom).getIndexJ()] = array[x][y];
                        array[x][y] = HOLE;
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    @Override
    public Matrix initializationMatrix(int size) {
        size = Math.max(size, MIN_SIZE_MATRIX);
        Atom[][] array = new Atom[size][size];
        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size; j++) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    array[i][j] = (j > (size / 2)) ? BLACK : BLUE;
                } else {
                    array[i][j] = HOLE;
                }
            }
        }
        return new Matrix(array);
    }

    @Override
    public void printMatrix(Matrix matrix) {
        Atom[][] array = matrix.getMatrix();
        for (Atom[] arr : array) {
            System.out.println(Arrays.toString(Arrays.stream(arr).map(Atom::getNumber).toArray()));
        }
    }

}
