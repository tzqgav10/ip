package peira.ui;

import peira.PeiraExceptions;
import peira.command.Command;
import peira.task.Task;

/**
 * Represents the main class for Peira
 * This class initializes the application, loads tasks from storage and runs
 * the main loop.
 *
 * @author Gavin
 * @version 1.0
 */
public class Peira {

    private Ui ui;
    private static Storage storage;

    /**
     * Creates a new instance of {@code Peira}.
     * Initializes the user interface, storage, and loads tasks from the file.
     */
    public Peira() {
        ui = new Ui();
        storage = new Storage();
        Task.getEntireList().addAll(storage.loadTasksFromFile());
    }

    /**
     * Runs the Peira application.
     * Displays a welcome message, processes user commands, and exits when the user requests.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(ui, storage);
                isExit = c.isExit();
            } catch (PeiraExceptions e) {
                ui.showError(e);
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The entry point of Peira where the run function is called.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        new Peira().run();
    }
}
