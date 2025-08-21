public class Todo extends Task {

    public Todo(String des) {
        super(des);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String taskToStr() {
        String num = super.isDone ? "1" : "0";
        StringBuilder sb = new StringBuilder();
        sb.append('T').append(" | ").append(num).append(" | ").append(super.des);
        return sb.toString();
    }

}
