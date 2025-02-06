public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public static void addTask(Task task) {
        entireList[totalTasks] = task;
        totalTasks++;
        System.out.println("    ____________________________________________________________");
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + task);
        System.out.println("    Now you have " + Task.totalTasks + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
    }

    @Override
    public String toString() {
        return "[E]" + "[" + super.getStatusIcon() + "]" + description + " (from: "
                + from + ", to: " + to + ")";
    }
}
