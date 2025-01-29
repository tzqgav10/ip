public class Task {
    private static int totalTasks = 0; // total number of tasks
    private static Task[] entireList = new Task[100];
    protected String description;
    protected boolean isDone;

    // constructor for list
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    // add task method
    public static void addTask(String taskDescription) {
        entireList[totalTasks] = new Task(taskDescription);
        totalTasks++;
    }
    // retrieve task's completion status method
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    // print tasks method
    public static void printTasks() {
        int index = 1;
        System.out.println("    Here are the tasks in your lists:");
        for (int i = 0; i < totalTasks; i++) {
            System.out.print("    " + index + ".");
            System.out.print("[" + entireList[i].getStatusIcon() + "] ");
            System.out.println(entireList[i].description);
            index++;
        }
    }
    // get total number of tasks
    public int getTotalTasks() {
        return totalTasks;
    }
    // mark done method
    // can consider adding exceptions for edge cases later on
    public static void markDone(int index) {
        entireList[index-1].isDone = true;
        System.out.println("    Nice! I've marked this task as done:");
        System.out.print("      " + "[" + entireList[index-1].getStatusIcon() + "] ");
        System.out.println(entireList[index-1].description);
    }
    // mark undone method
    // can consider adding exceptions for edge cases later on
    public static void markUndone(int index) {
        entireList[index-1].isDone = false;
        System.out.println("    OK, I've marked this task as undone:");
        System.out.print("      " + "[" + entireList[index-1].getStatusIcon() + "] ");
        System.out.println(entireList[index-1].description);
    }
}