package peira.command;

import peira.PeiraExceptions;
import peira.ui.Ui;
import peira.ui.Storage;

public abstract class Command {
    public abstract void execute(Ui ui, Storage storage) throws PeiraExceptions;
    public boolean isExit() {
        return false;
    }
}
