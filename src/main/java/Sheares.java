import java.util.Scanner;

public class Sheares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String zero = "    _____________________________\n";
        String first = "    Hello! I'm Sheares\n";
        String second = "    What can i do for you?\n";
        String third = "    Bye. Hope to see you again soon!\n";
        System.out.println(zero + first + second + zero);
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("bye")) {
                System.out.println(zero);
                break;
            } else {
                System.out.println(zero);
                System.out.println("    " + input);
                System.out.println(zero);
            }
        }
        System.out.println(third + zero);
    }
}
