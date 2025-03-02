package peira.command;

import peira.PeiraExceptions;
import peira.task.DateTime;
import peira.task.Deadline;
import peira.task.Event;
import peira.ui.Storage;
import peira.ui.Ui;

import java.time.LocalDateTime;

public class EventCommand extends Command {
    private String event;
    private String from;
    private String to;

    public EventCommand(String event, String from, String to) {
        this.event = event;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        try {
            LocalDateTime fromDateTime = DateTime.parseDateTime(from, "yyyy-M-d HHmm");
            String formattedFrom = DateTime.formatDateTime(fromDateTime);
            LocalDateTime toDateTime = DateTime.parseDateTime(to, "yyyy-M-d HHmm");
            String formattedTo = DateTime.formatDateTime(toDateTime);
            Event.addTask(new Event(event, formattedFrom, formattedTo));
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
            Event.addTask(new Event(event, from, to));
        }
    }
}
