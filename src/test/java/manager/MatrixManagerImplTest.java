package manager;

import entity.Atom;
import entity.Matrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static entity.Atom.*;

public class MatrixManagerImplTest {
    private MatrixManager matrixManager;
    private RandomManager random = Mockito.mock(RandomManager.class);

    @Before
    public void before() {
        this.matrixManager = new MatrixManagerImpl(random);
    }

    @Test
    public void mixMatrixFindHole() {
        //пробіл перед фігурною дужкою
        Atom[][] arrayBefore = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, HOLE, BLACK},
                {BLACK, HOLE, BLACK}};
        //пробіл перед фігурною дужкою
        Atom[][] arrayAfter = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, HOLE, BLACK},
                {BLACK, HOLE, BLACK}};
        Matrix matrixBefore = new Matrix(arrayBefore);
        //для чого ти ще раз мокаєш? .thenReturn(1,1)
        //це ти сказав, що коли другий раз визвуть це саме, то щоб знов дало 1
        Mockito.when(random.getIntRandom(0, 3)).thenReturn(1, 1);
        Mockito.when(random.getIntRandom(0, 2)).thenReturn(0);
        Assert.assertArrayEquals(arrayAfter, matrixManager.mixMatrix(matrixBefore).getMatrix());
    }

    @Test
    public void mixMatrixFindAtom() {
        //пробіл перед фігурною дужкою
        Atom[][] arrayBefore = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, HOLE, BLACK},
                {BLACK, HOLE, BLACK}};
        //пробіл перед фігурною дужкою
        Atom[][] arrayAfter = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, BLACK, BLACK},
                {BLACK, HOLE, HOLE}};
        Matrix matrixBefore = new Matrix(arrayBefore);
        //для чого ти ще раз мокаєш? .thenReturn(2,2)
        Mockito.when(random.getIntRandom(0, 3)).thenReturn(2,2);
        Mockito.when(random.getIntRandom(0, 2)).thenReturn(0);
        Assert.assertArrayEquals(arrayAfter, matrixManager.mixMatrix(matrixBefore).getMatrix());
    }//відступ
    @Test
    public void initializationMatrix() {
        //пробіл перед фігурною дужкою
        Atom[][] array = new Atom[][]{
                {HOLE, BLACK},
                {BLUE, HOLE}};
        Mockito.when(random.getBooleanRandom()).thenReturn(false,true,  true, false);
        Matrix matrixMock = matrixManager.initializationMatrix(2);
        Assert.assertArrayEquals(array, matrixMock.getMatrix());
    }

    @Test
    public void initializationMatrixSize() {
        Matrix matrix = matrixManager.initializationMatrix(5);
        Assert.assertEquals(5, matrix.getMatrix().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initializationMatrixMinus() {
        Matrix matrixMinus = matrixManager.initializationMatrix(-5);
        //тут сюди навіть не дійде, помилка вилетить на 1 стрічці
        //того цієї не треба
        Assert.assertEquals(2, matrixMinus.getMatrix().length);
    }

}