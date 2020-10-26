package repository;

public class MatrixRepositoryImpl implements MatrixRepository {
    private static final String[] ELEMENT = { "дірка" ,"червоний атом", "синій атом" };

    @Override
    public int[][] mixMatrix(int[][] matrix) {
        int length = matrix[0].length;
        int x =  (int) (Math.random() * length);
        int y = (int) (Math.random() * length);

        if (matrix[x][y] > 0) {
            for (int i = x == 0 ? 0 : x - 1; i < (x == length ? x : x + 1); i++) {
                for (int j = y == 0 ? 0 : y - 1; j < (y == length ? y : y + 1); j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = matrix[x][y];
                        matrix[x][y] = 0;
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    @Override
    public int[][] initializationMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int y = 0; y < size; y++) {
                if ((Math.random() * 2) == 0) {
                    matrix[i][y] = 1 + (i / (size / 2));
                }
            }
        }
        return matrix;
    }

}
