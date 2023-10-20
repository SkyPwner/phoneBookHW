package homework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtils {
    public static String getDateString() {
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        return simpleDateFormat.format(currentDate);
    }
}
