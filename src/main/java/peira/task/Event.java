package peira.task;

/**
 * Represents an event with specified start and end dates.
 * This class extends the {@link Task} class.
 *
 * @author Gavin
 * @version 1.0
 */
public class Event extends Task {

    /** Start date/time of the event */
    protected String from;

    /** End date/time of the event */
    protected String to;

    /**
     * Creates a new instance of {@code Event} with the specified description,
     * start and end date/time.
     *
     * @param description Description of the event.
     * @param from Start date/time of the event.
     * @param to End date/time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Creates a new instance of {@code Event} from a string representation
     * that is stored in a file.
     * The string format is expected to be "[E][X] description (from: start date/time,
     * to: end date/time)".
     *
     * @param fileString String representation of the entire task from the file.
     * @return A {@code Event} initialized with the description, start and end date/time.
     */
    public static Event fromFileString(String fileString) {
        boolean isDone = fileString.charAt(4) == 'X';
        int indexOfDescription = fileString.indexOf(" (");
        String description = fileString.substring(6, indexOfDescription);
        int indexOfFrom = fileString.indexOf("from: ");
        int endIndexOfFrom = fileString.indexOf(",");
        String from = fileString.substring(indexOfFrom + 6, endIndexOfFrom);
        int indexOfTo = fileString.indexOf("to: ");
        int endIndexOfTo = fileString.indexOf(")");
        String to = fileString.substring(indexOfTo + 4, endIndexOfTo);
        Event event = new Event(description, from, to);
        event.isDone = isDone;
        return event;
    }

    /**
     * Returns a string representation of the {@code Event}.
     * The format is: "[E][X] description (from: start date/time, to: end date/time)".
     *
     * @return A string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + "[" + super.getStatusIcon() + "] " + description + " (from: "
                + from + ", to: " + to + ")";
    }
}
