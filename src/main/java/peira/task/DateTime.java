package peira.task;

import peira.PeiraExceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTime {

    public static LocalDateTime parseDateTime (String date, String format) throws PeiraExceptions {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new PeiraExceptions("    Unable to parse date and time, using original input!");
        }
    }

    public static String formatDateTime (LocalDateTime date) {
        int day = date.getDayOfMonth();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = date.getYear();
        int hour = date.getHour();
        int minute = date.getMinute();
        int newHour = 0;

        if (hour > 12) {
            newHour = hour - 12;
        } else {
            newHour = hour;
        }

        return day + " " + month.substring(0, 3) + " " + year + ", " + (newHour == 0 ? "12" :
                newHour) + (minute != 0 ? minute :  "") + (hour > 12 ? "pm" : "am");
    }
}
