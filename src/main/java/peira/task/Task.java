package peira.task;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import peira.PeiraExceptions;

public class Task {
    protected static ArrayList<Task> entireList = new ArrayList<>();
    protected String description;
    protected boolean isDone;

    private static final String FILE_NAME = "tasks.txt";
    private static final Path FILE_PATH = Paths.get(System.getProperty("user.home"),
            "Peira", "data", FILE_NAME);

    // constructor for list
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    // add task method
    public static void addTask(Task task) {
        entireList.add(task); // integrates collection to add task
        System.out.println("    ____________________________________________________________");
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + task);
        System.out.println("    Now you have " + Task.entireList.size() + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
        saveTasksToFile();
    }
    // save tasks to data file for storage when making any changes to the list of tasks
    private static void saveTasksToFile() {
        try {
            // ensure the data directory exists
            Path parentDir = FILE_PATH.getParent();
            if (!Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            // write tasks to the file
            FileWriter writer = new FileWriter(FILE_PATH.toFile());
            for (Task task : entireList) {
                writer.write(task.toString() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("    Error saving tasks to file: " + e.getMessage());
        }
    }
    // determine which task to add
    public static Task fromFileString(String fileString) {
        if (fileString.startsWith("[T]")) {
            return Todo.fromFileString(fileString);
        } else if (fileString.startsWith("[D]")) {
            return Deadline.fromFileString(fileString);
        } else if (fileString.startsWith("[E]")) {
            return Event.fromFileString(fileString);
        } else {
            return null;
        }
    }
    // check if there is any data files previously created
    // if there is a data file, scan the file to add subsequent tasks to the list
    public static void loadTasksFromFile() {
        try {
            if (!Files.exists(FILE_PATH)) {
                System.out.println("    No existing tasks file found.");
                System.out.println("    Starting with an empty task list.");
                System.out.println("    ______________________________________" +
                        "______________________");
                return;
            }
            Scanner scanner = new Scanner(FILE_PATH.toFile());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.fromFileString(line);

                if (task != null) {
                    entireList.add(task);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("    Error loading tasks from file: " + e.getMessage());
        }
    }
    // retrieve task's completion status method
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    // print tasks method
    public static void printTasks() {
        if (entireList.isEmpty()) {
            System.out.println("    There are no tasks in your list!");
            return;
        }
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < entireList.size(); i++) {
            System.out.println("    " + (i + 1) + "." + entireList.get(i).toString());
        }
    }
    // mark done method
    // can consider adding exceptions for edge cases later on
    public static void markDone(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions("    Chosen index doesn't exist!");
        }
        entireList.get(index-1).isDone = true;
        System.out.println("    Nice! I've marked this task as done:");
        System.out.print("     " + "[" + entireList.get(index-1).getStatusIcon() + "]");
        System.out.println(entireList.get(index-1).description);
        saveTasksToFile();
    }
    // mark undone method
    // can consider adding exceptions for edge cases later on
    public static void markUndone(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions("    Chosen index doesn't exist!");
        }
        entireList.get(index-1).isDone = false;
        System.out.println("    OK, I've marked this task as undone:");
        System.out.print("     " + "[" + entireList.get(index-1).getStatusIcon() + "]");
        System.out.println(entireList.get(index-1).description);
        saveTasksToFile();
    }
    // remove task from list method
    public static void removeTask(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions("    Chosen index doesn't exist!");
        }
        System.out.println("    Okay, I have managed to delete this task:");
        System.out.println("     " + entireList.get(index-1).toString());
        entireList.remove(index-1);
        System.out.println("    Now you have " + entireList.size() + " tasks in the list.");
    }
}