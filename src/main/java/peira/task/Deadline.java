package peira.task;

/**
 * Represents a task with a specific deadline.
 * This class extends the {@link Task} class.
 *
 * @author Gavin
 * @version 1.0
 */
public class Deadline extends Task {

    /** The due date/time which the task needs to be completed by. */
    protected String by;

    /**
     * Creates a new instance of {@code Deadline} with the specified description and
     * due date/time.
     *
     * @param description Description of the task.
     * @param by Due date/time of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Creates a new instance of {@code Deadline} task from a string representation
     * that is stored in a file.
     * The string format is expected to be "[D][X] description (by: due date/time)".
     *
     * @param fileString String representation of the entire task from the file.
     * @return A {@code Deadline} initialized with the description and due date/time.
     */
    public static Deadline fromFileString(String fileString) {
        boolean isDone = fileString.charAt(4) == 'X';
        int indexOfDescription = fileString.indexOf(" (");
        String description = fileString.substring(7, indexOfDescription);
        int indexOfBy = fileString.indexOf("by: ");
        int endIndexOfBy = fileString.indexOf(")");
        String by = fileString.substring(indexOfBy + 4, endIndexOfBy);
        Deadline deadline = new Deadline(description, by);
        deadline.isDone = isDone;
        return deadline;
    }

    /**
     * Returns a string representation of the {@code Deadline} task.
     * The format is: "[D][X] description (by: due date/time)".
     *
     * @return A string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "] " + description + " (by: " + by + ")";
    }
}
