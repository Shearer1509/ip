package sheares.command;

import sheares.*;

public class ExitCommand extends Command {

    private boolean isExit;
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
