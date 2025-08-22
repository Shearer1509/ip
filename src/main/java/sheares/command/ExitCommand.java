package sheares.command;


import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;

/**
 * represents command to exit the chatbot
 */
public class ExitCommand extends Command {

    public boolean isExit;
    public ExitCommand() {
        super();
    }
    @Override
    public boolean isExit() {
        return true;
    }
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        System.out.println("    Bye. Hope to see you again soon!");
    }
}
