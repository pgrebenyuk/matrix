package user;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

public class UserInputManagerTest {
    private Scanner scanner = Mockito.mock(Scanner.class);

    @Test
    public void getMatrixSize() {
        Mockito.when(scanner.nextInt()).thenReturn(6);
        InputManager inputManager = new UserInputManager(scanner);
        Assert.assertEquals(6, inputManager.getMatrixSize());
    }

    @Test
    public void getMixesCount() {
        Mockito.when(scanner.nextInt()).thenReturn(3);
        InputManager inputManager = new UserInputManager(scanner);
        Assert.assertEquals(3, inputManager.getMixesCount());
    }
}