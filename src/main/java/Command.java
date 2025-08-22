abstract public class Command {

    boolean isExit;
    public Command() {
        this.isExit = false;
    }
    public boolean isExit() {
        return this.isExit;
    }
    abstract public void execute(TaskList ls, Ui ui, Storage storage);
}
