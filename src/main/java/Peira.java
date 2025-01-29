import java.util.Scanner;

public class Peira {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Peira.");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");

        while (true) {
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            int taskIndex = 0;
            if (line.startsWith("mark ")) {
                taskIndex = Integer.parseInt(line.substring(5));
                line = "mark";
            }
            if (line.startsWith("unmark ")) {
                taskIndex = Integer.parseInt(line.substring(7));
                line = "unmark";
            }
            switch (line) {
            case "bye":
                System.out.println("    ____________________________________________________________");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                return; // to exit the program entirely
            case "list":
                System.out.println("    ____________________________________________________________");
                Task.printTasks();
                System.out.println("    ____________________________________________________________");
                break;
            case "mark":
                System.out.println("    ____________________________________________________________");
                Task.markDone(taskIndex);
                System.out.println("    ____________________________________________________________");
                break;
            case "unmark":
                System.out.println("    ____________________________________________________________");
                Task.markUndone(taskIndex);
                System.out.println("    ____________________________________________________________");
                break;
            default:
                System.out.println("    ____________________________________________________________");
                System.out.println("    added: " + line);
                Task.addTask(line);
                System.out.println("    ____________________________________________________________");
                break;
            }
        }
    }
}
