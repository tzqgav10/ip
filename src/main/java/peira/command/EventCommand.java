package peira.command;

import peira.PeiraExceptions;
import peira.task.DateTime;
import peira.task.Deadline;
import peira.task.Event;
import peira.ui.Storage;
import peira.ui.Ui;
import java.time.LocalDateTime;

/**
 * Represents a command to add an event to the task list.
 * This command creates a {@link Event} with a description, stand and end time for the event.
 *
 * @author Gavin
 * @version 1.0
 */

public class EventCommand extends Command {
    private String event;
    private String from;
    private String to;

    /**
     * Creates a new instance of {@code EventCommand} with a specified description,
     * start date/time and end date/time.
     *
     * @param event Name/description of the event.
     * @param from Start date/time of the event.
     * @param to End date/time of the event.
     */
    public EventCommand(String event, String from, String to) {
        this.event = event;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the command by adding a new {@link Event} to the task list.
     *
     * @param ui The user interface.
     * @param storage Storage system used to read and save to the file.
     */
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
