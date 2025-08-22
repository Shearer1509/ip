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


}
