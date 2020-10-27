package manager;

import entity.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class MatrixManagerImplTest {
    //цього менеджера мжна лишити тут як поле
    private MatrixManager matrixManager = new MatrixManagerImpl();

    //а от матрицю краще вже ініціалізувати в конкретному тесті кожен раз і забрати звідси
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
        //краще зроби, щоб якщо мінус, то викидало IllegalArgumentException
        Matrix matrixMinus = matrixManager.initializationMatrix(-5);
        //пробіл чогось в параметрах вкінці
        Assert.assertEquals(2, matrixMinus.getMatrix().length );
    }

    //метод прінта ти не протестиш, бо по суті він нічого не робить

    //а от мікс метод зможеш протестити
    //для цього треба використати мокіто і замокати рандом, щоб дав тобі те, що треба
    //а для того, щоб його замокати, то його треба передавати в метод, чи клас, а не створювати прям там

    //ще в тебе не протестований клас UserInputManager

}