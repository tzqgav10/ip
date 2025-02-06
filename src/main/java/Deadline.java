public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
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
        return "[D]" + "[" + super.getStatusIcon() + "]" + description + " (by: " + by + ")";
    }
}
