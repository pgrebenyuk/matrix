package manager;

import entity.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class MatrixManagerImplTest {
    private MatrixManager matrixManager = new MatrixManagerImpl();
    private Matrix matrix = matrixManager.initializationMatrix(5);

    @Test
    public void initializationMatrix() {
        Assert.assertEquals(5, matrix.getMatrix().length);
    }

    @Test
    public void initializationMatrixFailed() {
        Assert.assertNotEquals(6, matrix.getMatrix().length );
    }

    @Test
    public void initializationMatrixMinus() {
        Matrix matrixMinus = matrixManager.initializationMatrix(-5);
        Assert.assertEquals(2, matrixMinus.getMatrix().length );
    }
}