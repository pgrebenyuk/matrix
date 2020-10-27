package User;

import java.util.Scanner;

//цю реалізацію можна назвати UserInputManager, бо в ній юзер ввдить дані
//пробіла немає перед дужкою фігурною
public class MatrixUserImpl implements MatrixUser{
    //поле без модифікатора
    Scanner scan;

    public MatrixUserImpl() {
        this.scan = new Scanner(System.in);
    }

    @Override
    //краще дати зрозуміти в назві, що цей метод запросить розміри
    //getMatrixSize()
    //майже все, що щось повертає починається з get (дай)
    public int sizeMatrix() {
        int size = 0;
        //ти зробив цикл і якщо юзер введе -1, то йому треба буде вводити ще
        //але він не зрозуміє своєї помилки, бо ти йому нічого не написав в разі помилки
        while (size < 2) { //цю 2 краще зробити константою і сказати, що це таке
            System.out.println("Enter the length of the matrix ( > 1): ");
            size = scan.nextInt();
        }
        return size;
    }

    @Override
    //назва getMixesNumber()
    public int numberMixes() {
        int number;
        do {
            System.out.println("Enter the number of mixes ( > 0) or 0 to exit: ");
            number = scan.nextInt();
        } while (number < 0); //знов таки, ніякого повідомлення юзеру, якщо неправильно вводить
        return number;
    }

}
