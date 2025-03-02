package peira.command;

import peira.PeiraExceptions;
import peira.ui.Ui;
import peira.ui.Storage;

/**
 * Represents a command that can be executed by Peira.
 * This is an abstract class that serves as the base for all input commands by the user.
 *
 * @author Gavin
 * @version 1.0
 */
public abstract class Command {
    public abstract void execute(Ui ui, Storage storage) throws PeiraExceptions;

    /**
     * Indicates whether the command is an exit command.
     * By default, commands are not exit commands.
     *
     * @return {@code true} if the command is an exit command, return {@code false} otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
