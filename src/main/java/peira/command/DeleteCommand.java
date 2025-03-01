package peira.command;

import peira.PeiraExceptions;
import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

public class DeleteCommand extends Command {
    private int taskIndex = 0;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            Task.removeTask(taskIndex);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
