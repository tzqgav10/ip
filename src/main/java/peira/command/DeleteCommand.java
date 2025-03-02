package peira.command;

import peira.PeiraExceptions;
import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

/**
 * Represents a command to delete a task from the task list.
 * This command removes the task based on the index that the user has
 * entered.
 *
 * @author Gavin
 * @version 1.0
 */
public class DeleteCommand extends Command {
    private int taskIndex = 0;

    /**
     * Creates a new instance of {@code DeleteCommand} with the index of the task
     * to be removed.
     *
     * @param taskIndex Index of the task to be removed.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command by removing the task specified by {@code taskIndex}.
     * If the index given by the user is invalid, an error message is displayed.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            Task.removeTask(taskIndex);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
