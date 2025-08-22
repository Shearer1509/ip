package sheares.exception;
public class DukeException extends Exception {
    private String msg;
    public DukeException() {
        this.msg = "    File not loaded ";
    }


    public String getMessage() {
        return this.msg;
    }
}
