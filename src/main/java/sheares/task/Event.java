package sheares.task;

/**
 * represents an Event Type Task
 */
public class Event extends Task{
    private String from;
    private String to;
    public Event(String des, String from, String to) {
        super(des);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }

    /**
     * returns String representation that we write to data file
     */
    public String taskToStr() {
        String num = super.isDone ? "1" : "0";
        StringBuilder sb = new StringBuilder();
        sb.append('E').append(" | ").append(num).append(" | ").append(super.des).append(" | ").
                append(this.from).append('-').append(this.to);
        return sb.toString();
    }
}
