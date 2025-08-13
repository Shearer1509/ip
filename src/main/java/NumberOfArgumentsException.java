public class NumberOfArgumentsException extends Exception {
    private String msg;
    public NumberOfArgumentsException(String command) {
        this.msg = "    Wrong number of arguments to " + command;
    }


    public String getMsg() {
        return this.msg;
    }
}
