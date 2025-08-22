package sheares.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    private final LocalDate deadline;
    public Deadline(String des, LocalDate deadline) {
        super(des);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        String formatted_deadline = this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[D]" + super.toString() + " (by: " + formatted_deadline + ")";
    }

    @Override
    public String taskToStr() {
        String num = super.isDone ? "1" : "0";
        StringBuilder sb = new StringBuilder();
        sb.append('D').append(" | ").append(num).append(" | ").append(super.des).append(" | ").append(this.deadline);
        return sb.toString();
    }
}
