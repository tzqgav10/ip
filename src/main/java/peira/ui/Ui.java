package peira.ui;

import peira.PeiraExceptions;

import java.util.Scanner;

public class Ui {

    private static final String INDENT = "    ";
    private static final String LINE = "____________________________________________________________";

    public void showLine() {
        System.out.println(INDENT + LINE);
    }

    public void showError(PeiraExceptions e) {
        System.out.println(e.getMessage());
        if (e.getMessage().equals(INDENT + "Can you enter a valid command please?")) {
            System.out.println(INDENT + "If you've already entered a valid command, please remember");
            System.out.println(INDENT + "to add a space in front of your command!");
        }
    }

    public void showWelcome() {
        showLine();
        System.out.println(INDENT + "Hello! I'm Peira.");
        System.out.println(INDENT + "What can I do for you?");
        showLine();
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        return line;
    }

    public void showGoodbye() {
        System.out.println(INDENT + "Bye. Hope to see you again soon!");
    }
}