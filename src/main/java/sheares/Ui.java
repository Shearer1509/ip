package sheares;
import java.util.Scanner;

public class Ui {

    Scanner scanner;
    public Ui() {
        this.scanner = new Scanner(System.in);
    }
    public void showLine() {
        System.out.println("    _____________________________");
    }

    public void showWelcome() {
        String first = "    Hello! I'm Sheares";
        String second = "    What can i do for you?";
        this.showLine();
        System.out.println(first);
        System.out.println(second);
        this.showLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        this.showLine();
        System.out.println("    This is your first time using this chatbot");
        this.showLine();
    }
    public String readCommand() {
        return scanner.nextLine().trim();
    }
}
