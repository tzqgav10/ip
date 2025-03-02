package peira.command;

import peira.PeiraExceptions;
import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

/**
 * Represents a command to change the status of a task to be incomplete.
 * The specified task is chosen based on the index that the user enters.
 *
 * @author Gavin
 * @version 1.0
 */
public class UnmarkCommand extends Command {
    private int taskIndex = 0;

    /**
     * Creates a new instance of {@code UnmarkCommand} with a specified task index.
     *
     * @param taskIndex Index of the task to be marked as incomplete.
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command by calling a method from {@link Task} that marks the task
     * specified by the {@code taskIndex} as incomplete.
     * If the index given by the user is invalid, an error message is displayed.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            Task.markUndone(taskIndex);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
