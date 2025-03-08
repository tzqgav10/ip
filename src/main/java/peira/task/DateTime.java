package peira.task;

import peira.PeiraExceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Represents a date and time
 * This class has methods to parse a given string to make a string
 * consisting of date and time
 *
 * @author Gavin
 * @version 1.0
 */
public class DateTime {

    private final static String INDENT = "    ";

    /**
     * Parses a date-time string into a {@link LocalDateTime} object using the specified format.
     * If the parsing fails, {@link PeiraExceptions} is thrown with an error message.
     *
     * @param date The date-time string to parse.
     * @param format The pattern to use for parsing.
     * @return The parsed {@link LocalDateTime} object.
     * @throws PeiraExceptions If the date-time string cannot be parsed using the specified format.
     */
    public static LocalDateTime parseDateTime (String date, String format) throws PeiraExceptions {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new PeiraExceptions(INDENT + "Unable to parse date and time, using original input!");
        }
    }

    /**
     * Formats a {@link LocalDateTime} object into a human-readable string.
     * The format includes the day, abbreviated month name, year, and
     * time in 12-hour format with AM/PM.
     *
     * @param date The {@link LocalDateTime} object to format
     * @return The formatted date-time string
     */
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
