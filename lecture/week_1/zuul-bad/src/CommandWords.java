/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords {

    private enum validCommands {
        GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");

        private final String command;

        validCommands(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }
    }
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     *
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString) {
        for (var command : validCommands.values()) {
            if (command.getCommand().equals(aString)) return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
