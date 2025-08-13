import java.util.ArrayList;
import java.util.Scanner;

public class Sheares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] ans = new Task[100];
        int numOfTasks = 0;
        String zero = "    _____________________________";
        String first = "    Hello! I'm Sheares";
        String second = "    What can i do for you?";
        String third = "    Bye. Hope to see you again soon!";
        System.out.println(zero);
        System.out.println(first);
        System.out.println(second);
        System.out.println(zero);
        boolean loop = true;
        while (loop) {
            String input = sc.nextLine().trim();
            String[] line = input.split(" ");
            String command = line[0];
            switch (command) {
                case "bye" :
                    System.out.println(zero);
                    loop = false;
                    break;
                case "list" :
                    System.out.println(zero);
                    System.out.println("    Here are the tasks in your list:");
                    for (int i = 0; i < numOfTasks; i++) {
                        Task curr = ans[i];
                        System.out.println("    " + (i+1) + "." + curr);
                    }
                    System.out.println(zero);
                    break;
                case "mark" :
                    int index = Integer.parseInt(line[1]);
                    Task curr = ans[index-1];
                    curr.mark();
                    System.out.println(zero);
                    System.out.println("    Nice! I've marked this task as done:");
                    System.out.println("      " + curr);
                    System.out.println(zero);
                    break;
                case "unmark":
                    int index2 = Integer.parseInt(line[1]);
                    Task curr2 = ans[index2-1];
                    curr2.unmark();
                    System.out.println(zero);
                    System.out.println("    OK, I've marked this task as not done yet:");
                    System.out.println("      " + curr2);
                    System.out.println(zero);
                    break;
                case "todo":
                    String[] arr = input.split("todo ");
                    String info = arr[1];
                    Task curr3 = new Todo(info);
                    ans[numOfTasks] = curr3;
                    numOfTasks++;
                    System.out.println(zero);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("      " + curr3);
                    System.out.println("    Now you have " + numOfTasks+ " tasks in the list.");
                    System.out.println(zero);
                    break;
                case "deadline":
                    String[] arr2 = input.split("deadline ");
                    String info2 = arr2[1];
                    String[] arr3 = info2.split(" /by ");
                    Task curr4 = new Deadline(arr3[0], arr3[1]);
                    ans[numOfTasks] = curr4;
                    numOfTasks++;
                    System.out.println(zero);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("      " + curr4);
                    System.out.println("    Now you have " + numOfTasks+ " tasks in the list.");
                    System.out.println(zero);
                    break;
                case "event":
                    String[] arr4 = input.split("event ");
                    String info3 = arr4[1];
                    String[] arr5 = info3.split(" /from ");
                    String des = arr5[0];
                    String rest = arr5[1];
                    String[] last = rest.split(" /to ");

                    Task curr5 = new Event(des, last[0], last[1]);
                    ans[numOfTasks] = curr5;
                    numOfTasks++;
                    System.out.println(zero);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("      " + curr5);
                    System.out.println("    Now you have " + numOfTasks+ " tasks in the list.");
                    System.out.println(zero);
                    break;
                default:
                    ans[numOfTasks] = new Task(input);
                    System.out.println(zero);
                    System.out.println("    added: " + input);
                    System.out.println(zero);
                    numOfTasks++;
                    break;
            }
        }
        System.out.println(third);
        System.out.println(zero);
    }
}
