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
    //ніхто не використовує
    private Matrix matrix;
    private Atom[][] array;
    private RandomManager random = Mockito.mock(RandomManager.class);

    @Before
    public void before() {
        //не дивишся що пишеш, вдступи лажові, коми, пробіли
        this.array = new Atom[][]{
                {HOLE, BLACK},
                {BLUE, HOLE, }};

        this.matrix = new Matrix(array);
        this.matrixManager = new MatrixManagerImpl(random);
    }

    @Test
    public void mixMatrix() {
        //крутий тест, але ні каплі не тестує мікс, от прям взагалі
        Mockito.when(random.getBooleanRandom()).thenReturn(false,true,  true, false);
        Matrix matrixMock = matrixManager.initializationMatrix(2);
        Assert.assertArrayEquals(array, matrixMock.getMatrix());
    }

    @Test
    public void initializationMatrix() {
        Matrix matrix = matrixManager.initializationMatrix(5);
        Assert.assertEquals(5, matrix.getMatrix().length);
    }

    @Test
    public void initializationMatrixFailed() {
        Matrix matrix = matrixManager.initializationMatrix(5);
        Assert.assertNotEquals(6, matrix.getMatrix().length );
    }

    @Test(expected = IllegalArgumentException.class)
    public void initializationMatrixMinus() {
        Matrix matrixMinus = matrixManager.initializationMatrix(-5);
        Assert.assertEquals(2, matrixMinus.getMatrix().length);
    }

}