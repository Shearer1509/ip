public class Deadline extends Task{
    private String deadline;
    public Deadline(String des, String deadline) {
        super(des);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadline + ")";
    }

    @Override
    public String taskToStr() {
        String num = super.isDone ? "1" : "0";
        StringBuilder sb = new StringBuilder();
        sb.append('D').append(" | ").append(num).append(" | ").append(super.des).append(" | ").append(this.deadline);
        return sb.toString();
    }
}
