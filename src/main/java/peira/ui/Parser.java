package peira.ui;

import peira.command.*;
import peira.PeiraExceptions;

/**
 * Parses user input into executable commands.
 * This class is responsible for interpreting user commands and creating the respective
 * command objects.
 *
 * @author Gavin
 * @version 1.0
 */
public class Parser {
    /**
     * Parses the full user command and returns the corresponding {@link Command} object.
     *
     * @param fullCommand The full command entered by the user.
     * @return The {@link Command} object corresponding to the user's input.
     * @throws PeiraExceptions If the command is invalid or cannot be parsed.
     */
    public static Command parse(String fullCommand) throws PeiraExceptions {
        if (fullCommand.startsWith("todo ")) {
            return new TodoCommand(fullCommand.substring(5));
        } else if (fullCommand.startsWith("deadline ")) {
            return parseDeadline(fullCommand.substring(9));
        } else if (fullCommand.startsWith("event ")) {
            return parseEvent(fullCommand.substring(6));
        } else if (fullCommand.startsWith("mark ")) {
            return new MarkCommand(Integer.parseInt(fullCommand.substring(5)));
        } else if (fullCommand.startsWith("unmark ")) {
            return new UnmarkCommand(Integer.parseInt(fullCommand.substring(7)));
        } else if (fullCommand.startsWith("delete ")) {
            return new DeleteCommand(Integer.parseInt(fullCommand.substring(7)));
        } else if (fullCommand.startsWith("find ")) {
            return new FindCommand(fullCommand.substring(5));
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else if (fullCommand.equals("bye")) {
            return new ExitCommand();
        } else {
            throw new PeiraExceptions("    Can you enter a valid command please?");
        }
    }

    private static Command parseDeadline(String input) throws PeiraExceptions {
        // need to check early if the line is empty or else there will be index exception
        if (input.trim().isEmpty()) {
            throw new PeiraExceptions("    Hey! What do you need to do? When must you complete it?");
        }
        int byIndex = -1;
        byIndex = input.indexOf(" /by ");
        // check if /by is included in the command
        if (byIndex == -1) {
            throw new PeiraExceptions("    So... when's the deadline?");
        }
        String description = input.substring(0, byIndex);
        String by = input.substring(byIndex + 5);
        return new DeadlineCommand(description, by);
    }

    private static Command parseEvent(String input) throws PeiraExceptions {
        if (input.trim().isEmpty()) {
            throw new PeiraExceptions("    So... what event are you going to?");
        }
        int fromIndex = -1;
        fromIndex = input.indexOf(" /from ");
        if (fromIndex == -1) {
            throw new PeiraExceptions("    So... when does the event start?");
        }
        String description = input.substring(0, fromIndex);
        int toIndex = -1;
        toIndex = input.indexOf(" /to ");
        if (toIndex == -1) {
            throw new PeiraExceptions("    So... when does the event end?");
        }
        String from = input.substring(fromIndex + 7, toIndex);
        String to = input.substring(toIndex + 5);
        return new EventCommand(description, from, to);
    }
}