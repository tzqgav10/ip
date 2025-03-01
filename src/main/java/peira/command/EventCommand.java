package peira.command;

import peira.task.Event;
import peira.ui.Storage;
import peira.ui.Ui;

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
        Event.addTask(new Event(event, from, to));
    }
}
