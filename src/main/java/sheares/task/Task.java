package sheares.task;
abstract public class Task {
    protected String des;
    protected boolean isDone;

    public Task(String des) {
        this.des = des;
        this.isDone = false;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String getIcon() {
        return isDone ? "X" : " ";
    }

    public String getDescription() {
        return this.des;
    }

    abstract public String taskToStr();

    @Override
    public String toString() {
        return "[" + this.getIcon() + "] " + this.des;
    }
}
