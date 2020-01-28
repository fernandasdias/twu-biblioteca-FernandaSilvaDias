import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    public static void main(String[] args) {
        List<Books> booksList = new ArrayList<>();
        //booksList = getListOfBooks();
        boolean status = true;

        while (status)
         status  =  Menu.executeMenu();

    }

}

