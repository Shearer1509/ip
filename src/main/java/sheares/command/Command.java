package sheares.command;

import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;

/**
 * abstract class that represents a command, execution differs based on subclass
 */
abstract public class Command {

    boolean isExit;
    public Command() {
        this.isExit = false;
    }
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * executes the corresponding command, and edits TaskList, UI, and Storage if needed
     * @param ls
     * @param ui
     * @param storage
     */
    abstract public void execute(TaskList ls, Ui ui, Storage storage);
}
