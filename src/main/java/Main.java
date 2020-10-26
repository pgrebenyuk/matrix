public class Main {

    public static void main(String[] args) {
        int[][] myArray1;
        int[][] myArray2;

        do {
            myArray1 = MatrixOld.initDoubleMatrix();
            myArray2 = MatrixOld.initDoubleMatrix();
        } while (!MatrixOld.compareDoubleMatrices(myArray1, myArray2));

        MatrixOld.maxSameElements(myArray1, myArray2);
    }
}
