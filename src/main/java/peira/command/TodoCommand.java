package peira.command;

import peira.task.Task;
import peira.task.Todo;
import peira.ui.Ui;
import peira.ui.Storage;
import peira.PeiraExceptions;

/**
 * Represents a command to add a todo task to the task list.
 * This command creates a {@link Todo} task with a description.
 *
 * @author Gavin
 * @version 1.0
 */
public class TodoCommand extends Command {
    private String description;

    /**
     * Creates a new instance of {@code TodoCommand} with a specified description.
     *
     * @param description Description of the task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by calling a method from {@link Task} to add a new
     * {@link Todo} task to the task list.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     * @throws PeiraExceptions Throws an error if the task description is empty.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws PeiraExceptions {
        if (description.trim().isEmpty()) {
            throw new PeiraExceptions("    How can I add something that is empty??");
        }
        Task.addTask(new Todo(description));
    }
}