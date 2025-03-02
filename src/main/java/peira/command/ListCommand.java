package peira.command;

import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

/**
 * Represents a command to print out all the tasks in the current task list.
 *
 * @author Gavin
 * @version 1.0
 */
public class ListCommand extends Command {

    /**
     * Executes the command by calling a method from {@link Task} to print out
     * all the tasks in the task list.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        Task.printTasks();
    }
}
