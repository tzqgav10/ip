package peira.ui;

import peira.task.Deadline;
import peira.task.Event;
import peira.task.Task;
import peira.task.Todo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class Storage {
    private static final String FILE_NAME = "tasks.txt";
    private static final Path FILE_PATH = Paths.get(System.getProperty("user.home"),
            "Peira", "data", FILE_NAME);

    // save tasks to data file for storage when making any changes to the list of tasks
    public static void saveTasksToFile(ArrayList<Task> entireList) {
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
    public ArrayList<Task> loadTasksFromFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            if (!Files.exists(FILE_PATH)) {
                System.out.println("    No existing tasks file found.");
                System.out.println("    Starting with an empty task list.");
                System.out.println("    ______________________________________" +
                        "______________________");
                return tasks;
            }
            Scanner scanner = new Scanner(FILE_PATH.toFile());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = fromFileString(line);

                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("    Error loading tasks from file: " + e.getMessage());
        }
        return tasks;
    }
}