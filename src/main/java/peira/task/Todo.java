package peira.task;

/**
 * Represents a todo task.
 * This class extends the {@link Task} class.
 *
 * @author Gavin
 * @version 1.0
 */
public class Todo extends Task {

    /**
     * Creates a new instance of {@code Todo} with the specified description.
     *
     * @param description Description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Creates a new instance of {@code Todo} task from a string representation
     * that is stored in a file.
     * The string format is expected to be "[T][X] description".
     *
     * @param fileString String representation of the entire task from the file.
     * @return A {@code Todo} initialized with the description.
     */
    public static Todo fromFileString(String fileString) {
        boolean isDone = fileString.charAt(4) == 'X';
        String description = fileString.substring(7);
        Todo todo = new Todo(description);
        todo.isDone = isDone;
        return todo;
    }

    /**
     * Returns a string representation of the {@code Todo} task.
     * The format is: "[T][X] description".
     *
     * @return A string representation of the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + "[" + super.getStatusIcon() + "] " + description;
    }
}
