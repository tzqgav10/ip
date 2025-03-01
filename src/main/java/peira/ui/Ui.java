package peira.ui;

import peira.PeiraExceptions;

import java.util.Scanner;

public class Ui {

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void showError(PeiraExceptions e) {
        System.out.println(e.getMessage());
        if (e.getMessage().equals("    Can you enter a valid command please?")) {
            System.out.println("    If you've already entered a valid command, please remember");
            System.out.println("    to add a space in front of your command!");
        }
    }

    public void showWelcome() {
        showLine();
        System.out.println("    Hello! I'm Peira.");
        System.out.println("    What can I do for you?");
        showLine();
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        return line;
    }

    public void showGoodbye() {
        System.out.println("    Bye. Hope to see you again soon!");
    }
}