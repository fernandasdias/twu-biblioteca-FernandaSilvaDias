import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Books {

    String name, author;
    Integer year, ID;
    Boolean checkoutStatus = false;
    protected static List<Books> booksList = getListOfBooks();
    static Integer operationReturn = 2, operationCheckout = 1;

    public Books(String name, String author, Integer year, Integer ID)
    {
        this.name = name;
        this.author = author;
        this.year = year;
        this.ID = ID;
    }

    public static boolean listAllBooks(List<Books> booksList) {

        if (VerifyIfListIsEmpty(booksList))
            return false;

        for (Books book : booksList) {

            if (book.checkoutStatus.equals(false)) {
                System.out.print(" \n " + book.ID + " | " + book.name + " | "+ book.author + " | " + book.year + " | ");
            }
        }
        return true;
    }

    public static List<Books> getListOfBooks() {

        Books book1 = new Books("Book one", "Author one", 2011, 1);
        Books book2 = new Books("Book two", "Author two", 2019, 2);
        Books book3 = new Books("Book three", "Author three", 2001, 3);

        List<Books> booksList = new ArrayList<>();
        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);

        return booksList;
    }

    private static boolean VerifyIfListIsEmpty(List<Books> booksList) {

        if (booksList.size() == 0) {
            System.out.println("\n There is no books in the library.");
            return true;
        }
        return false;
    }

    public static void listAndChooseBookToCheckoutOrReturn(Integer operationID) {

        Scanner in = new Scanner(System.in);

       if(operationID.equals(operationCheckout))
           Books.listAllBooks(booksList);

        System.out.println("\n Choose a book ID to perform the operation:");
        Integer bookID = in.nextInt();
        verifyBookIDFromLibrary(bookID, operationID);
    }

    protected static boolean verifyBookIDFromLibrary(Integer bookID, Integer operation) {

        List<Books> bList =  booksList.stream().filter(books -> books.ID == bookID).collect(Collectors.toList());

        if (bList.size() == 0){
            System.out.println("\n This book doesnt belong to this library" );
            return false;
        }
        if (operation.equals(operationCheckout))
            return checkoutBook(bList.get(0));
        else
            return returnBooks(bList.get(0));
    }

    public static boolean checkoutBook(Books book) {

        if (book.checkoutStatus.equals(true)) {
            System.out.println("\n Sorry, the book is not available!");
            return false;
        } else {
            System.out.println("\n Thank you! Enjoy the book!");
        }
        book.checkoutStatus = true;
        return true;
    }

    public static boolean returnBooks(Books book) {
    
       if(checkBookCheckoutStatus(book)){

           book.checkoutStatus = false;
           System.out.println("\n Thank you for returning the book!");
           return true;
       }
       System.out.println("\n This is not a valid book to return.");
        return false;
    }

    private static boolean checkBookCheckoutStatus(Books book) {
        return book.checkoutStatus.equals(true);
    }
}
