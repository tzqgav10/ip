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

/**
 * Handles reading and saving tasks to the file that stores tasks.
 * This class is responsible for saving tasks to the file and loading tasks from the file
 * at the start of the application.
 *
 * @author Gavin
 * @version 1.0
 */
public class Storage {
    private static final String FILE_NAME = "tasks.txt";
    private static final Path FILE_PATH = Paths.get(System.getProperty("user.home"),
            "Peira", "data", FILE_NAME);
    private static final String INDENT = "    ";
    private static final String LINE = "____________________________________________________________";

    /**
     * Saves the list of tasks to the file.
     * If the file or directory does not exist, it will be created.
     *
     * @param entireList The list of tasks to be saved.
     */
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
            System.out.println(INDENT + "Error saving tasks to file: " + e.getMessage());
        }
    }
    /**
     * Determines the type of task from a string representation and creates the
     * corresponding task object.
     *
     * @param fileString The string representation of the task from the file.
     * @return The task object corresponding to the string representation, or
     * {@code null} if the string is invalid.
     */
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

    /**
     * Loads tasks from the file into a list.
     * If the file does not exist, an empty list is returned.
     *
     * @return A list of tasks loaded from the file.
     */
    public ArrayList<Task> loadTasksFromFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            if (!Files.exists(FILE_PATH)) {
                System.out.println(INDENT + "No existing tasks file found.");
                System.out.println(INDENT + "Starting with an empty task list.");
                System.out.println(INDENT + LINE);
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
            System.out.println(INDENT + "Error loading tasks from file: " + e.getMessage());
        }
        return tasks;
    }
}