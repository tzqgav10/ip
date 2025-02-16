package peira.command;

import peira.PeiraExceptions;
import peira.task.Deadline;
import peira.task.Event;
import peira.task.Task;
import peira.task.Todo;

import java.util.Scanner;

public class Peira {
    public static void main(String[] args) {
        handleGreeting();

        Scanner in = new Scanner(System.in);

        while (true) {
            String line;
            line = in.nextLine();
            int taskIndex = 0;
            try {
                if (line.startsWith("mark ")) {
                    taskIndex = Integer.parseInt(line.substring(5));
                    handleMarkDone(taskIndex);
                } else if (line.startsWith("unmark ")) {
                    taskIndex = Integer.parseInt(line.substring(7));
                    handleMarkUndone(taskIndex);
                } else if (line.startsWith("todo ")) {
                    handleTodo(line);
                } else if (line.startsWith("deadline ")) {
                    handleDeadline(line);
                } else if (line.startsWith("event ")) {
                    handleEvent(line);
                } else if (line.startsWith("bye")) {
                    handleExit();
                    return;
                } else if (line.startsWith("list")) {
                    handleList();
                } else if (line.startsWith("delete ")) {
                    taskIndex = Integer.parseInt(line.substring(7));
                    handleDelete(taskIndex);
                } else {
                    // handle exception where command is not understood
                    throw new PeiraExceptions("    Can you enter a valid command please?");
                }
            } catch (PeiraExceptions e) {
                printLine();
                System.out.println(e.getMessage());
                System.out.println("    If you've already entered a valid command, please remember");
                System.out.println("    to add a space in front of your command!");
                printLine();
            }
        }
    }

    private static void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    private static void handleGreeting() {
        printLine();
        System.out.println("    Hello! I'm Peira.");
        System.out.println("    What can I do for you?");
        printLine();
    }

    // creates a new todo in list of tasks
    private static void handleTodo(String line) {
        try {
            line = line.substring(4);
            if (line.trim().isEmpty()) {
                throw new PeiraExceptions("    How can I add something that is empty??");
            }
            Todo.addTask(new Todo(line));
        } catch (PeiraExceptions e) {
            printLine();
            System.out.println(e.getMessage());
            printLine();
        }
    }

    // creates a new deadline in list of tasks
    private static void handleDeadline(String line) {
        try {
            line = line.substring(8);
            // need to check early if the line is empty or else there will be index exception
            if (line.trim().isEmpty()) {
                throw new PeiraExceptions("    Hey! What do you need to do? When must you complete it?");
            }
            int byIndex = -1;
            byIndex = line.indexOf(" /by ");
            // check if /by is included in the command
            if (byIndex == -1) {
                throw new PeiraExceptions("    So... when's the deadline?");
            }
            String description = line.substring(0, byIndex);
            String by = line.substring(byIndex + 5);
            Deadline.addTask(new Deadline(description, by));
        } catch (PeiraExceptions e) {
            printLine();
            System.out.println(e.getMessage());
            printLine();
        }
    }

    // creates a new event in list of tasks
    private static void handleEvent(String line) {
        try {
            line = line.substring(5);
            if (line.trim().isEmpty()) {
                throw new PeiraExceptions("    So... what event are you going to?");
            }
            int fromIndex = -1;
            fromIndex = line.indexOf(" /from ");
            if (fromIndex == -1) {
                throw new PeiraExceptions("    So... when does the event start?");
            }
            String description = line.substring(0, fromIndex);
            int toIndex = -1;
            toIndex = line.indexOf(" /to ");
            if (toIndex == -1) {
                throw new PeiraExceptions("    So... when does the event end?");
            }
            String by = line.substring(fromIndex + 7, toIndex);
            String to = line.substring(toIndex + 5);
            Event.addTask(new Event(description, by, to));
        } catch (PeiraExceptions e) {
            printLine();
            System.out.println(e.getMessage());
            printLine();
        }
    }

    private static void handleMarkDone(int taskIndex) {
        printLine();
        try {
            Task.markDone(taskIndex);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
        printLine();
    }

    private static void handleMarkUndone(int taskIndex) {
        printLine();
        try {
            Task.markUndone(taskIndex);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
        printLine();
    }

    private static void handleExit() {
        printLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printLine();
    }

    private static void handleList() {
        printLine();
        Task.printTasks();
        printLine();
    }

    private static void handleDelete(int index) {
        printLine();
        try {
            Task.removeTask(index);
        } catch (PeiraExceptions e) {
            System.out.println(e.getMessage());
        }
        printLine();
    }
}
