package peira.task;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }
    // method to initialize description, from and to for event
    public static Event fromFileString(String fileString) {
        boolean isDone = fileString.charAt(4) == 'X';
        int indexOfDescription = fileString.indexOf(" (");
        String description = fileString.substring(6, indexOfDescription);
        int indexOfFrom = fileString.indexOf("from: ");
        int endIndexOfFrom = fileString.indexOf(",");
        String from = fileString.substring(indexOfFrom + 6, endIndexOfFrom);
        int indexOfTo = fileString.indexOf("to: ");
        int endIndexOfTo = fileString.indexOf(")");
        String to = fileString.substring(indexOfTo + 4, endIndexOfTo);
        Event event = new Event(description, from, to);
        event.isDone = isDone;
        return event;
    }

    @Override
    public String toString() {
        return "[E]" + "[" + super.getStatusIcon() + "] " + description + " (from: "
                + from + ", to: " + to + ")";
    }
}
