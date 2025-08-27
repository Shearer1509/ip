package sheares.command;

import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;
import sheares.task.Task;

/**
 * represents task to unmark task (incomplete)
 */
public class UnMarkCommand extends Command {

    private final int index;
    public UnMarkCommand(int index) {
        super();
        this.index = index;
    }

    @Override
    public void execute(TaskList ls, Ui ui, Storage storage) {
        Task curr = ls.get(this.index);
        curr.unmark();
        storage.save(ls);
        System.out.println("    OK, I've marked this task as not done yet:");
        System.out.println("      " + curr);
    }

    @Override
    public String executeWithString(TaskList ls, Ui ui, Storage storage) {
        Task curr = ls.get(this.index);
        curr.unmark();
        storage.save(ls);
        String s = "";
        s += "    OK, I've marked this task as not done yet: " + "\n";
        s += "      " + curr + "\n";
        return s;
    }
}