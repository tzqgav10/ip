public class Task {
    private static int totalTasks; // total number of tasks
    private static String[] entireList = new String[100];

    // constructor for list
    public Task() {
        totalTasks = 0;
    }
    // add task method
    public static void addTask(String task) {
        entireList[totalTasks] = task;
        totalTasks++;
    }
    // print tasks method
    public static void printTasks() {
        int index = 1;
        for (int i = 0; i < totalTasks; i++) {
            System.out.print("    " + index + ". ");
            System.out.println(entireList[i]);
            index++;
        }
    }
    // get total number of tasks
    public int getTotalTasks() {
        return totalTasks;
    }
}