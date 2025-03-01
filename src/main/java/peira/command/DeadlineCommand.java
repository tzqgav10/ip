package peira.command;

import peira.task.Deadline;
import peira.ui.Storage;
import peira.ui.Ui;

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        Deadline.addTask(new Deadline(description, by));
    }
}
