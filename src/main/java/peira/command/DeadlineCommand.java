package peira.command;

import peira.task.Deadline;
import peira.ui.Storage;
import peira.ui.Ui;

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
        Deadline.addTask(new Deadline(description, by));
    }
}
