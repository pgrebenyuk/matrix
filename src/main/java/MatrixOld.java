public class MatrixOld {
    private final static int NUMBER_OF_ROWS = 10;
    private final static int NUMBER_OF_COLUMNS = 10;
    private final static int MIN_RANDOM = 2;
    private final static int MAX_RANDOM = 9;

    static int[][] initDoubleMatrix() {
        int[][] array = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int y = 0; y < NUMBER_OF_COLUMNS; y++) {
                array[i][y] = (int) (Math.random() * (MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM);
                System.out.print(array[i][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return array;
    }

    static boolean compareDoubleMatrices(int[][] myArray1, int[][] myArray2) {
        int maxSame = 10;
        int same = 0;

        if ((myArray1.length != myArray2.length) && (myArray1[0].length != myArray2[0].length)) {
            throw new IllegalArgumentException("the matrices must be the same length");
        }

        for (int i = 0; i < myArray1.length; i++) {
            for (int y = 0; y < myArray1[0].length; y++) {
                if (myArray1[i][y] == myArray2[i][y]) {
                    same++;
                }
            }
        }

        System.out.println(maxSame > same);
        return (maxSame > same);
    }

    static void maxSameElements(int[][] myArray1, int[][] myArray2) {
        int row = 0;
        int rowSameElements;
        int rowMaxSameElements = 0;

        if ((myArray1.length != myArray2.length) && (myArray1[0].length != myArray2[0].length)) {
            throw new IllegalArgumentException("the matrices must be the same length");
        }

        for (int i = 0; i < myArray1.length; i++) {
            rowSameElements = 0;
            for (int y = 0; y < myArray1[0].length; y++) {
                if (myArray1[i][y] == myArray2[i][y]) {
                    rowSameElements++;
                }
            }
            if (rowSameElements > rowMaxSameElements) {
                rowMaxSameElements = rowSameElements;
                row = i + 1;
            }
        }

        System.out.println("row " + row + " the sames elements " + rowMaxSameElements);
    }
}
