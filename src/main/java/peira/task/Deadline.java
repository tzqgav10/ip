package peira.task;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    // method to initialize description and by for deadline
    public static Deadline fromFileString(String fileString) {
        boolean isDone = fileString.charAt(4) == 'X';
        int indexOfDescription = fileString.indexOf(" (");
        String description = fileString.substring(6, indexOfDescription);
        int indexOfBy = fileString.indexOf("by: ");
        int endIndexOfBy = fileString.indexOf(")");
        String by = fileString.substring(indexOfBy + 4, endIndexOfBy);
        Deadline deadline = new Deadline(description, by);
        deadline.isDone = isDone;
        return deadline;
    }

    @Override
    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "]" + description + " (by: " + by + ")";
    }
}
