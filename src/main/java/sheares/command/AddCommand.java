package sheares.command;

import java.time.LocalDate;

import sheares.Storage;
import sheares.TaskList;
import sheares.Ui;
import sheares.task.Deadline;
import sheares.task.Event;
import sheares.task.Task;
import sheares.task.Todo;

/**
 * Represents a new command to add task to list
 */
public class AddCommand extends Command {

    private final String des;
    private LocalDate deadline;
    private String to;
    private String from;
    private final int index;

    /**
     * Creates an AddCommand for a toDo
     * @param des
     */
    public AddCommand(String des) {
        super();
        this.des = des;
        this.index = 0;
    }

    /**
     * Creates an AddCommand for a deadline
     * @param des
     */
    public AddCommand(String des, LocalDate date) {
        this.des = des;
        this.deadline = date;
        this.index = 1;
    }

    /**
     * Creates an AddCommand for an event
     * @param des
     */
    public AddCommand(String des, String from, String to) {
        this.des = des;
        this.to = to;
        this.from = from;
        this.index = 2;
    }

    @Override
    public void execute(TaskList ls, Ui ui, Storage storage) {
        Task curr = null;
        if (this.index == 0) {
            curr = new Todo(this.des);
        } else if (this.index == 1) {
            curr = new Deadline(this.des, this.deadline);
        } else {
            curr = new Event(this.des, this.from, this.to);
        }
        ls.add(curr);
        storage.save(ls);
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + curr);
        System.out.println("    Now you have " + ls.size() + " tasks in the list.");
    }

    @Override
    public String executeWithString(TaskList ls, Ui ui, Storage storage) {
        Task curr = null;
        if (this.index == 0) {
            curr = new Todo(this.des);
        } else if (this.index == 1) {
            curr = new Deadline(this.des, this.deadline);
        } else {
            curr = new Event(this.des, this.from, this.to);
        }
        ls.add(curr);
        storage.save(ls);
        return "    Got it. I've added this task: \n" + "      "
                + curr + "\n" + "    Now you have " + ls.size() + " tasks in the list.";
    }
}
