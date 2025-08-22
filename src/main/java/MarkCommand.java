public class MarkCommand extends Command {

    private int index;
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
}