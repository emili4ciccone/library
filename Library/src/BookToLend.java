import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookToLend implements Landable {

    private Book book;
    private Calendar expirationDate;
    private Calendar lendingDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private boolean lent;

    public BookToLend(Book book) {
        this.book = book;
        this.lent = false;
    }
    @Override
    public boolean isLent() {
        return this.lent;
    }

    @Override
    public void lend(Date currentDate) {
        if (lendingDate == null) {
            lendingDate = Calendar.getInstance();
        }
        if (expirationDate == null) {
            expirationDate = Calendar.getInstance();
        }

        if (lent) {
            System.out.println(this.book.getTitle() + " is already lent. The current lent will end on " + sdf.format(expirationDate.getTime()) + "\n");
        } else {
            lendingDate.setTime(currentDate);
            expirationDate.setTime(currentDate);
            expirationDate.add(Calendar.MONTH, 1);
            this.lent = true;
            System.out.println("The book " + this.book.getTitle() + " has been lent to you.\nThe lent will end on " + sdf.format(expirationDate.getTime()) + "\n");
        }

    }

    @Override
    public void giveBack(Date currentDate) {
        if (currentDate.after(expirationDate.getTime())) {
            System.out.println("You have returned the book " + this.book.getTitle() + " after the lent expiration date.\n");
        } else {
            System.out.println("You have returned the book " + this.book.getTitle() + " in time. Thank you!\n");
        }
        this.lent = false;
    }

    @Override
    public Calendar getExpirationDate() {
        return this.expirationDate;
    }
}
