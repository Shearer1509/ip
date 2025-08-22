public class WrongInputException extends DukeException {
    private String msg;
    public WrongInputException() {
        this.msg = "    Input not recognised";
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
