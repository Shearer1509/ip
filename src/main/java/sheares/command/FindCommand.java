package sheares.command;

import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;
import sheares.task.Task;

/**
 * represents command to find tasks based on keyword
 */
public class FindCommand extends Command{

    private String keyWord;
    private int found;
    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
        this.found = 0;
    }
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        System.out.println("    Here are the matching tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            Task curr = list.get(i);
            if (curr.getDescription().contains(this.keyWord)) {
                System.out.println("    " + (this.found + 1) + "." + curr);
                this.found++;
            }
        }
    }
}
