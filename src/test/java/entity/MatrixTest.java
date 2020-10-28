package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static entity.Atom.*;

public class MatrixTest {
    private Matrix matrix;
    private Atom[][] array;


    @Before
    public void before() {
        //відступ перед дужкою
        this.array = new Atom[][]{
                {HOLE, BLUE, BLACK},
                {HOLE, BLUE, HOLE},
                {BLACK, BLUE, BLACK}};

        this.matrix = new Matrix(array);
    }

    @Test
    public void getMatrix() {
        matrix.getMatrix();
        Assert.assertArrayEquals(array, matrix.getMatrix());
    }

}