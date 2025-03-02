package peira.command;

import peira.PeiraExceptions;
import peira.task.DateTime;
import peira.task.Deadline;
import peira.ui.Storage;
import peira.ui.Ui;

import java.time.LocalDateTime;

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            LocalDateTime dateTime = DateTime.parseDateTime(by, "yyyy-M-d HHmm");
            String formattedDateTime = DateTime.formatDateTime(dateTime);
            Deadline.addTask(new Deadline(description, formattedDateTime));
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
            Deadline.addTask(new Deadline(description, by));
        }
    }
}
