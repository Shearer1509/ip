package sheares.command;

import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;
import sheares.task.Task;

/**
 * represents command to list out all tasks in list
 */
public class ListCommand extends Command {

    public ListCommand() {
        super();
    }

    @Override
    public void execute(TaskList ls, Ui ui, Storage storage) {

        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < ls.size(); i++) {
            Task curr = ls.get(i);
            System.out.println("    " + (i + 1) + "." + curr);
        }
    }

    @Override
    public String executeWithString(TaskList ls, Ui ui, Storage storage) {
        String s = "";
        s += "    Here are the tasks in your list: \n";
        for (int i = 0; i < ls.size(); i++) {
            Task curr = ls.get(i);
            s += "      " + (i + 1) + "." + curr + "\n";
        }
        return s;
    }
}
