package peira.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }
    // method to initialize description for task to do
    public static Todo fromFileString(String fileString) {
        boolean isDone = fileString.charAt(4) == 'X';
        String description = fileString.substring(6);
        Todo todo = new Todo(description);
        todo.isDone = isDone;
        return todo;
    }

    @Override
    public String toString() {
        return "[T]" + "[" + super.getStatusIcon() + "] " + description;
    }
}
