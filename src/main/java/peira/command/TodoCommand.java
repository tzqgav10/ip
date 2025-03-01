package peira.command;

import peira.task.Task;
import peira.task.Todo;
import peira.ui.Ui;
import peira.ui.Storage;
import peira.PeiraExceptions;

public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws PeiraExceptions {
        if (description.trim().isEmpty()) {
            throw new PeiraExceptions("    How can I add something that is empty??");
        }
        Task.addTask(new Todo(description));
    }
}