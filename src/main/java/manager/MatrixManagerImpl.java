package manager;

import entity.Atom;
import entity.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static entity.Atom.*;

public class MatrixManagerImpl implements MatrixManager {
    private static final int MIN_SIZE_MATRIX = 2;
    private RandomManager randomManager;

    public MatrixManagerImpl(RandomManager randomManager) {
        this.randomManager = randomManager;
    }

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
        int x = randomManager.getIntRandom(0, length);
        int y = randomManager.getIntRandom(0, length);

        if (array[x][y] != HOLE) {
            List<Index> list = new ArrayList<>();
            for (int i = Math.max(x - 1, 0); i < Math.min(x + 1, length - 1); i++) {
                for (int j = Math.max(y - 1, 0); j < Math.min(y + 1, length - 1); j++) {
                    if (i != x && j != y) {
                        if (array[i][j] == HOLE) {
                            list.add(new Index(i, j));
                        }
                    }
                }
            }

            if (list.size() > 0) {
                array[list.get(randomManager.getIntRandom(0, list.size())).getIndexI()]
                        [list.get(randomManager.getIntRandom(0, list.size())).getIndexJ()] = array[x][y];
                array[x][y] = HOLE;
                return matrix;
            }
        }
        return matrix;
    }

    @Override
    public Matrix initializationMatrix(int size) {
        if (size < 3)  {
            throw new IllegalArgumentException("Matrix's size can be > 2!");
        }
        size = Math.max(size, MIN_SIZE_MATRIX);
        Atom[][] array = new Atom[size][size];
        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size; j++) {
                if (randomManager.getBooleanRandom()) {
                    array[i][j] = (j >= (size / 2)) ? BLACK : BLUE;
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
