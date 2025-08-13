public class WrongInputException extends Exception {
    private String msg;
    public WrongInputException() {
        this.msg = "    Input not recognised";
    }


    public String getMsg() {
        return this.msg;
    }
}
