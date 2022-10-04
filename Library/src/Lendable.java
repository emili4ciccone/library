import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Lendable {

    private boolean lent;
    private Calendar lendingDate;
    private Calendar expirationDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public boolean isLent() {
        return lent;
    }

    public void setLent(boolean lent) {
        this.lent = lent;
    }

    public void lend(Date currentDate) {
        if (lendingDate == null) {
            lendingDate = Calendar.getInstance();
        }
        if (expirationDate == null) {
            expirationDate = Calendar.getInstance();
        }

        if (lent) {
            System.out.println("The item you chose is already lent. The current lent will end on " + sdf.format(expirationDate.getTime()));
        } else {
            lendingDate.setTime(currentDate);
            expirationDate.setTime(currentDate);
            expirationDate.add(Calendar.MONTH, 1);
            this.lent = true;
            System.out.println("The item has been lent to you.\nThe lent will end on " + sdf.format(expirationDate.getTime()));
        }
    }

    public void takeBack(Date currentDate) {

        if (currentDate.after(expirationDate.getTime())) {
            System.out.println("You have returned the item after the lent expiration date.");
        } else {
            System.out.println("You have returned the item in time. Thank you!");
        }
        this.lent = false;
    }

    public Calendar getExpirationDate() {
        return this.expirationDate;
    }

}
