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
            if (line.contains("bye")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break;
            } else if (line.contains("list")){
                System.out.println("    ____________________________________________________________");
                Task.printTasks();
                System.out.println("    ____________________________________________________________");
            } else {
                System.out.println("    ____________________________________________________________");
                System.out.println("    added: " + line);
                Task.addTask(line);
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}
