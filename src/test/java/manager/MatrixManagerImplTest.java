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
        Atom[][] array = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, HOLE, BLACK},
                {BLACK, HOLE, BLACK}};
        Matrix matrix = new Matrix(array);
        Mockito.when(random.getIntRandom(0, 2)).thenReturn(0,3);
        Matrix matrixMock = matrixManager.mixMatrix(matrix);
        Assert.assertArrayEquals(array, matrixMock.getMatrix());
    }

    @Test
    public void mixMatrixFindAtom() {
        Atom[][] arrayBefore = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, HOLE, BLACK},
                {BLACK, HOLE, BLACK}};
        Atom[][] arrayAfter = new Atom[][]{
                {HOLE, BLACK, HOLE},
                {BLUE, BLACK, BLACK},
                {BLACK, HOLE, HOLE}};
        Matrix matrix = new Matrix(arrayBefore);
        Mockito.when(random.getIntRandom(0, 3)).thenReturn(2,2);
        Mockito.when(random.getIntRandom(0, 2)).thenReturn(0);
        Matrix matrixMock = matrixManager.mixMatrix(matrix);
        Assert.assertArrayEquals(arrayAfter, matrixMock.getMatrix());
    }
    @Test
    public void initializationMatrix() {
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
        Assert.assertEquals(2, matrixMinus.getMatrix().length);
    }

}