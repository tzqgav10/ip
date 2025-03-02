package peira.command;

import peira.PeiraExceptions;
import peira.task.DateTime;
import peira.task.Deadline;
import peira.ui.Storage;
import peira.ui.Ui;
import java.time.LocalDateTime;

/**
 * Represents a command to add a deadline task to the task list.
 * This command creates a {@link Deadline} task with a description and a due date/time.
 *
 * @author Gavin
 * @version 1.0
 */

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    /**
     * Creates a new instance of {@code DeadlineCommand} with a specified description
     * and due date/time.
     *
     * @param description Description of the task.
     * @param by Due date/time for the task to be completed.
     */
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the command by adding a new {@link Deadline} task to the task list.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            LocalDateTime dateTime = DateTime.parseDateTime(by, "yyyy-M-d HHmm");
            String formattedDateTime = DateTime.formatDateTime(dateTime);
            Deadline.addTask(new Deadline(description, formattedDateTime));
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
            Deadline.addTask(new Deadline(description, by));
        }
    }
}
