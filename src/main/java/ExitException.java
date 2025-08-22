public class ExitException extends DukeException {
    private String msg;
    public ExitException() {
        this.msg =  "    Bye. Hope to see you again soon!";
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
