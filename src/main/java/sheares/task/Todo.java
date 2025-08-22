package sheares.task;

/**
 * represents a Todo Type Task
 */
public class Todo extends Task {

    public Todo(String des) {
        super(des);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * returns String representation that we write to data file
     */
    @Override
    public String taskToStr() {
        String num = super.isDone ? "1" : "0";
        StringBuilder sb = new StringBuilder();
        sb.append('T').append(" | ").append(num).append(" | ").append(super.des);
        return sb.toString();
    }

}
