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
}
