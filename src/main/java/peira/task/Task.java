package peira.task;

import java.util.ArrayList;
import peira.PeiraExceptions;
import peira.ui.Storage;

public class Task {
    protected String description;
    protected boolean isDone;
    protected static ArrayList<Task> entireList = new ArrayList<>();

    // getter for entireList
    public static ArrayList<Task> getEntireList() {
        return entireList;
    }

    // constructor for list
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    // add task method
    public static void addTask(Task task) {
        entireList.add(task); // integrates collection to add task
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + task);
        System.out.println("    Now you have " + Task.entireList.size() + " tasks in the list.");
        Storage.saveTasksToFile(entireList);
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
        System.out.println("     " + entireList.get(index-1).toString());
        Storage.saveTasksToFile(entireList);
    }
    // mark undone method
    // can consider adding exceptions for edge cases later on
    public static void markUndone(int index) throws PeiraExceptions {
        if (index < 0 || index > entireList.size()) {
            throw new PeiraExceptions("    Chosen index doesn't exist!");
        }
        entireList.get(index-1).isDone = false;
        System.out.println("    OK, I've marked this task as undone:");
        System.out.println("     " + entireList.get(index-1).toString());
        Storage.saveTasksToFile(entireList);
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
        Storage.saveTasksToFile(entireList);
    }
}