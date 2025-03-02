package peira.command;

import peira.task.Deadline;
import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

public class FindCommand extends Command {
    private String description;

    public FindCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        Task.printTasksWithKeyword(description);
    }
}
