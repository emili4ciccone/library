import java.util.ArrayList;
import java.util.Date;

public class Library {

    private ArrayList<BookToLend> books;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean isAvailable(BookToLend book) {
        return books.contains(book);
    }

    public void addBook(BookToLend book) {
        this.books.add(book);
    }

    public void lend(BookToLend book) {
        if (this.isAvailable(book)) {
            Date today = new Date();
            book.lend(today);
        } else {
            throw new IllegalArgumentException("The book you chose is not available in this Library.");
        }
    }

    public void giveBack(BookToLend book) {
        if (this.isAvailable(book)) {
            if (book.isLent()) {
                book.giveBack(new Date());
            } else {
                System.out.println("You have not lent this book.");
            }
        } else throw new IllegalArgumentException("The book you want to give back is not available in this Library.");
    }
}
