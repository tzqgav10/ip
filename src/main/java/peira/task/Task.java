package peira.task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

import peira.PeiraExceptions;
import peira.ui.Storage;

/**
 * Represents a task in the task lists.
 * This class serves as the base class for different types of tasks (e.g. deadline, event).
 *
 * @author Gavin
 * @version 1.0
 */
public class Task {

    private static final String INDENT = "    ";
    private static final String LONGERINDENT = "      ";

    /** Description of the task. */
    protected String description;

    /** Status of the task if it is completed. */
    protected boolean isDone;

    /** List containing all the tasks. */
    protected static ArrayList<Task> entireList = new ArrayList<>();

    /**
     * Retrieve the list of tasks.
     *
     * @return The list of tasks.
     */
    public static ArrayList<Task> getEntireList() {
        return entireList;
    }

    /**
     * Creates a new {@code Task} with a specified description.
     * The task is initially marked as not done.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Adds a task to the task list and saves the updated list to storage.
     *
     * @param task The task to be added.
     */
    public static void addTask(Task task) {
        entireList.add(task); // integrates collection to add task
        System.out.println(INDENT + "Got it. I've added this task:");
        System.out.println(LONGERINDENT + task);
        System.out.println(INDENT + "Now you have " + Task.entireList.size() + " tasks in the list.");
        Storage.saveTasksToFile(entireList);
    }

    /**
     * Returns the status icon of the task.
     * A done task is marked with "X", and an undone task is marked with a space.
     *
     * @return The status icon of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Prints all tasks in the task list.
     * If the list is empty, a message indicating no tasks is displayed.
     */
    public static void printTasks() {
        if (entireList.isEmpty()) {
            System.out.println(INDENT + "There are no tasks in your list!");
            return;
        }
        System.out.println(INDENT + "Here are the tasks in your list:");
        for (int i = 0; i < entireList.size(); i++) {
            System.out.println(INDENT + (i + 1) + "." + entireList.get(i).toString());
        }
    }

    public static void printTasksWithKeyword(String keyword) {
        if (entireList.isEmpty()) {
            System.out.println(INDENT + "There are no tasks in your list!");
            return;
        }
        ArrayList<Task> filteredList = entireList.stream().filter(task -> task.description !=
                        null && task.description.toLowerCase().contains(keyword.toLowerCase()))
                                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.isEmpty()) {
            System.out.println(INDENT + "There are no matching tasks in your list!");
            return;
        }
        System.out.println(INDENT + "Here are the matching tasks in your list:");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(INDENT + (i + 1) + "." + filteredList.get(i).toString());
        }
    }
    /**
     * Marks a task as done based on its index in the task list.
     *
     * @param index The index of the task to be marked as done.
     * @throws PeiraExceptions If the index is invalid.
     */
    public static void markDone(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions(INDENT + "Chosen index doesn't exist!");
        }
        entireList.get(index - 1).isDone = true;
        System.out.println(INDENT + "Nice! I've marked this task as done:");
        System.out.println(LONGERINDENT + entireList.get(index - 1).toString());
        Storage.saveTasksToFile(entireList);
    }

    /**
     * Marks a task as undone based on its index in the task list.
     *
     * @param index The index of the task to be marked as done.
     * @throws PeiraExceptions If the index is invalid.
     */
    public static void markUndone(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions(INDENT + "Chosen index doesn't exist!");
        }
        entireList.get(index - 1).isDone = false;
        System.out.println(INDENT + "OK, I've marked this task as undone:");
        System.out.println(LONGERINDENT + entireList.get(index - 1).toString());
        Storage.saveTasksToFile(entireList);
    }

    /**
     * Removes a task from the task list based on its index.
     *
     * @param index The index of the task to be removed.
     * @throws PeiraExceptions If the index is invalid.
     */
    public static void removeTask(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions(INDENT + "Chosen index doesn't exist!");
        }
        System.out.println(INDENT + "Okay, I have managed to delete this task:");
        System.out.println(LONGERINDENT + entireList.get(index - 1).toString());
        entireList.remove(index - 1);
        System.out.println(INDENT + "Now you have " + entireList.size() + " tasks in the list.");
        Storage.saveTasksToFile(entireList);
    }
}