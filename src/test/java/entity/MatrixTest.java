package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static entity.Atom.*;

public class MatrixTest {
    //коми ставлять в тій ж стрічці
//    private Atom[][] array= {{HOLE, BLUE, BLACK},
//            {HOLE, BLUE, HOLE},
//            {BLACK, BLUE, BLACK}};
    private Atom[][] array= {{HOLE, BLUE, BLACK}
                            ,{HOLE, BLUE, HOLE}
                            ,{BLACK, BLUE, BLACK}};
    private Matrix matrix = new Matrix(array);

    /*
    ініціалізувати можна так
    цей метод буде визиватись перед кожним новим класом теста
    тоді змінної array тобі взагалі не треба буде

    @Before
    public void before() {
        Atom[][] array= {{HOLE, BLUE, BLACK},
            {HOLE, BLUE, HOLE},
            {BLACK, BLUE, BLACK}};

        this.matrix = new Matrix(array);
    }

    ще є @BeforeClass
    визветься один раз перед всіма тестами
    */

    @Test
    public void getMatrix() {
        matrix.getMatrix();
        Assert.assertArrayEquals(array, matrix.getMatrix());
    }

}