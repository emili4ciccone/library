import java.util.Calendar;
import java.util.Date;

public interface Landable {

    public boolean isLent();

    public void lend(Date currentDate);

    public void giveBack(Date currentDate);

    public Calendar getExpirationDate();
}
