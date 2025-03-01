package peira.command;

import peira.PeiraExceptions;
import peira.task.Task;
import peira.ui.Storage;
import peira.ui.Ui;

public class MarkCommand extends Command {
    private int taskIndex = 0;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            Task.markDone(taskIndex);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
