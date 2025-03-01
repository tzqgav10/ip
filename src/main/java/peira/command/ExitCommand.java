package peira.command;

import peira.ui.Storage;
import peira.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute (Ui ui, Storage storage) {
        ui.showGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
