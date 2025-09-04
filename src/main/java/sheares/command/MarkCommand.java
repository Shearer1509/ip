package sheares.command;

import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;
import sheares.task.Task;

/**
 * represents command to mark task as complete
 */
public class MarkCommand extends Command {

    private final int index;

    /**
     * Creates new MarkCommand to mark task of that index as done
     * @param index
     */
    public MarkCommand(int index) {
        super();
        this.index = index;
    }

    @Override
    public void execute(TaskList ls, Ui ui, Storage storage) {
        Task curr = ls.get(this.index);
        curr.mark();
        storage.save(ls);
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + curr);
    }

    @Override
    public String executeWithString(TaskList ls, Ui ui, Storage storage) {
        Task curr = ls.get(this.index);
        curr.mark();
        storage.save(ls);
        //String s = "";
        StringBuilder sb = new StringBuilder();
        sb.append("    Nice! I've marked this task as done: \n");
        sb.append("      " + curr + "\n");
//        s += "    Nice! I've marked this task as done: \n";
//        s += "      " + curr + "\n";
        return sb.toString();
    }
}
