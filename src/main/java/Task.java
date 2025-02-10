public class Task {
    protected static int totalTasks = 0; // total number of tasks
    private static final int MAX_TASKS = 100;
    protected static Task[] entireList = new Task[MAX_TASKS];
    protected String description;
    protected boolean isDone;

    // constructor for list
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    // add task method
    public static void addTask(Task task) {
        entireList[totalTasks] = task;
        totalTasks++;
        System.out.println("    ____________________________________________________________");
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + task);
        System.out.println("    Now you have " + Task.totalTasks + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
    }
    // retrieve task's completion status method
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    // print tasks method
    public static void printTasks() {
        int index = 1;
        if (totalTasks == 0) {
            System.out.println("    There are no tasks in your list!");
            return;
        }
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < totalTasks; i++) {
            System.out.println("    " + (i + 1) + "." + entireList[i].toString());
        }
    }
    // get total number of tasks
    public int getTotalTasks() {
        return totalTasks;
    }
    // mark done method
    // can consider adding exceptions for edge cases later on
    public static void markDone(int index) throws PeiraExceptions{
        if (index < 0 || index > totalTasks) {
            throw new PeiraExceptions("    Chosen index doesn't exist!");
        }
        entireList[index-1].isDone = true;
        System.out.println("    Nice! I've marked this task as done:");
        System.out.print("     " + "[" + entireList[index-1].getStatusIcon() + "]");
        System.out.println(entireList[index-1].description);
    }
    // mark undone method
    // can consider adding exceptions for edge cases later on
    public static void markUndone(int index) throws PeiraExceptions {
        if (index < 0 || index > totalTasks) {
            throw new PeiraExceptions("    Chosen index doesn't exist!");
        }
        entireList[index-1].isDone = false;
        System.out.println("    OK, I've marked this task as undone:");
        System.out.print("     " + "[" + entireList[index-1].getStatusIcon() + "]");
        System.out.println(entireList[index-1].description);
    }
}