import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final String INITIAL_MESSAGE = "\nWelcome";

    public static boolean executeMenu() { //FUNCAO COMECA COM MINUSCULA

        int option;

        Scanner in = new Scanner(System.in);

        System.out.println(INITIAL_MESSAGE);

        showMenu();

        option = in.nextInt();

        return verifyValidOption(option);
    }

    public static Boolean verifyValidOption(int option) {

        switch(option) {
            case 1:
                Books.listAllBooks(Books.booksList);
                break;
            case 2:
                Books.listAndChooseBookToCheckoutOrReturn(Books.operationCheckout);
                break;

            case 3:
                Books.listAndChooseBookToCheckoutOrReturn(Books.operationReturn);
                break;

            case 4:
                System.exit(1);
                break;

            default:
                System.out.println("Please select a valid option. ");
                return false;
        }
        return true;
    }

    private static void showMenu() {

        System.out.println("\n Select one option:");
        System.out.println("    1 - List of Books");
        System.out.println("    2 - Checkout");
        System.out.println("    3 - Return");
        System.out.println("    4 - Exit");
    }
}

