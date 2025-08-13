import java.util.ArrayList;
import java.util.Scanner;

public class Sheares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ans = new String[100];
        int numOfTasks = 0;
        String zero = "    _____________________________";
        String first = "    Hello! I'm Sheares";
        String second = "    What can i do for you?";
        String third = "    Bye. Hope to see you again soon!";
        System.out.println(zero);
        System.out.println(first);
        System.out.println(second);
        System.out.println(zero);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println(zero);
                break;
            } else if (input.equals("list")) {
                System.out.println(zero);
                for (int i = 0; i < numOfTasks; i++) {
                    System.out.println("    " + (i+1) + ". " + ans[i]);
                }
                System.out.println(zero);
            } else {
                ans[numOfTasks] = input;
                System.out.println(zero);
                System.out.println("    added: " + input);
                System.out.println(zero);
                numOfTasks++;
            }
        }
        System.out.println(third);
        System.out.println(zero);
    }
}
