import java.util.Scanner;

public class Peira {
    public static void main(String[] args) {
        printLine();
        System.out.println("    Hello! I'm Peira.");
        System.out.println("    What can I do for you?");
        printLine();

        Scanner in = new Scanner(System.in);

        while (true) {
            String line;
            line = in.nextLine();
            int taskIndex = 0;
            if (line.startsWith("mark ")) {
                taskIndex = Integer.parseInt(line.substring(5));
                line = "mark";
            } else if (line.startsWith("unmark ")) {
                taskIndex = Integer.parseInt(line.substring(7));
                line = "unmark";
            } else if (line.startsWith("todo ")) {
                handleTodo(line);
            } else if (line.startsWith("deadline ")) {
                handleDeadline(line);
            } else if (line.startsWith("event ")) {
                handleEvent(line);
            }
            switch (line) {
            case "bye":
                printLine();
                System.out.println("    Bye. Hope to see you again soon!");
                printLine();
                return; // to exit the program entirely
            case "list":
                printLine();
                Task.printTasks();
                printLine();
                break;
            case "mark":
                printLine();
                Task.markDone(taskIndex);
                printLine();
                break;
            case "unmark":
                printLine();
                Task.markUndone(taskIndex);
                printLine();
                break;
            default:
                // System.out.println("    Instructions unclear. Please input a valid command!");
                break;
            }
        }
    }

    private static void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    // creates a new todo in list of tasks
    private static void handleTodo(String line) {
        line = line.substring(4);
        Todo.addTask(new Todo(line));
    }

    // creates a new deadline in list of tasks
    private static void handleDeadline(String line) {
        line = line.substring(8);
        int byIndex = line.indexOf(" /by ");
        String description = line.substring(0, byIndex);
        String by = line.substring(byIndex + 5);
        Deadline.addTask(new Deadline(description, by));
    }

    // creates a new event in list of tasks
    private static void handleEvent(String line) {
        line = line.substring(5);
        int fromIndex = line.indexOf(" /from ");
        String description = line.substring(0, fromIndex);
        int toIndex = line.indexOf(" /to ");
        String by = line.substring(fromIndex + 7, toIndex);
        String to = line.substring(toIndex + 5);
        Event.addTask(new Event(description, by, to));
    }
}
