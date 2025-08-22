public class UnMarkCommand extends Command {

    private int index;
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
}