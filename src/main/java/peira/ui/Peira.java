package peira.ui;

import peira.PeiraExceptions;
import peira.command.Command;
import peira.task.Deadline;
import peira.task.Event;
import peira.task.Task;
import peira.task.Todo;

public class Peira {

    private Ui ui;
    private static Storage storage;

    public Peira() {
        ui = new Ui();
        storage = new Storage();
        Task.getEntireList().addAll(storage.loadTasksFromFile());
    }

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

    public static void main(String[] args) {
        new Peira().run();
    }
}
