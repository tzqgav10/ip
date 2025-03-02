package peira.command;

import peira.task.Deadline;
import peira.ui.Storage;
import peira.ui.Ui;

/**
 * Represents a command to exit the program.
 *
 * @author Gavin
 * @version 1.0
 */
public class ExitCommand extends Command {

    /**
     * Executes the command by displaying a farewell message with a method from {@link Ui}.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     */
    @Override
    public void execute (Ui ui, Storage storage) {
        ui.showGoodbye();
    }

    /**
     * Sets the {@code isExit} flag to true if the exit command is called.
     * This allows the program to exit.
     *
     * @return Sets {@code isExit} to true.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
