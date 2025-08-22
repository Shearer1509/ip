package sheares.task;

/**
 * abstract representation of a task, exact behaviour determined by subclasses
 */
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

    /**
     *
     * @return X if task is done, space otherwise
     */
    public String getIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * returns String representation that we write to data file
     */
    abstract public String taskToStr();

    @Override
    public String toString() {
        return "[" + this.getIcon() + "] " + this.des;
    }
}
