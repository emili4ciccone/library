public class Main {
    public static void main(String[] args) {
        BookToLend alice = new BookToLend(new Book("Alice in Wonderland"));
        BookToLend flies = new BookToLend(new Book("Lord of the Flies"));
        BookToLend hp = new BookToLend(new Book("Harry Potter and the Order of Pheonix"));

        Library myLibrary = new Library();

        myLibrary.addBook(alice);
        myLibrary.addBook(flies);
        myLibrary.lend(alice);
        myLibrary.lend(flies);
        myLibrary.lend(alice);
        myLibrary.giveBack(alice);
        myLibrary.lend(alice);
        myLibrary.lend(hp);

    }
}