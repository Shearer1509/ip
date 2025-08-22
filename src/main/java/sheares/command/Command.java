package sheares.command;
import sheares.*;

/**
 * abstract class for command, execution depends on subclass
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
     * executes corresponding command by editing tasklist, ui and storage
     * @param ls
     * @param ui
     * @param storage
     */
    abstract public void execute(TaskList ls, Ui ui, Storage storage);
}
