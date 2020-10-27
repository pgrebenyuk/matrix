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
        var array = matrix.getMatrix();
        var length = array[0].length;
        var x = new Random().nextInt(length);
        var y = new Random().nextInt(length);

        //отстойно виглядить в методі, може краще хай буде в класі?
        class Index {
            private int indexI;
            private int indexJ;

            //невикористовується
            public Index() {}

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
                        //в даному випадку цей вар навіть мішає мені швидко зрозуміти, що це інт
                        var indexRandom = new Random().nextInt(list.size());
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
        var array = new Atom[size][size];
        for (var i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                var random = new Random();
                if (random.nextBoolean()) {
                    array[i][j] = (j > (size / 2)) ? Atom.BLACK : Atom.BLUE;
                } else {
                    array[i][j] = Atom.HOLE;
                }
            }
        }
        //зразу в конструктор
        Matrix matrix = new Matrix();
        matrix.setMatrix(array);
        return matrix;
    }

    @Override
    public void printMatrix(Matrix matrix) {
        Atom[][] array = matrix.getMatrix();
        for (var arr : array) {
            System.out.println(Arrays.toString(Arrays.stream(arr).map(Atom::getNumber).toArray()));
        }
    }

}
