package entity;

import org.junit.Assert;
import org.junit.Test;

import static entity.Atom.*;

public class MatrixTest {
    private Atom[][] array= {{HOLE, BLUE, BLACK}
                            ,{HOLE, BLUE, HOLE}
                            ,{BLACK, BLUE, BLACK}};
    private Matrix matrix = new Matrix(array);

    @Test
    public void getMatrix() {
        matrix.getMatrix();
        Assert.assertArrayEquals(array, matrix.getMatrix());
    }

}