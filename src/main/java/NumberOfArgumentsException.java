public class NumberOfArgumentsException extends DukeException {
    private String msg;
    public NumberOfArgumentsException(String command) {
        this.msg = "    Wrong number of arguments to " + command;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
