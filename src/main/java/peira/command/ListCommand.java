package peira.command;

import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(Ui ui, Storage storage) {
        Task.printTasks();
    }
}
