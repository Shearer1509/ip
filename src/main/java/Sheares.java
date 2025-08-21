import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Sheares {


    public static void helper(ArrayList<Task> ls) {
        try {
            FileWriter fw = new FileWriter("./data/duke.txt");
            for (Task task : ls) {
                String output = task.taskToStr();
                fw.write(output + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("file writing off");
        }
    }


    public static void main(String[] args) {

        String filePath = "./data/duke.txt";
        Path path = Paths.get(filePath);
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> ans = new ArrayList<>();
        int numOfTasks = 0;

        try {
            Path parentDir = path.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            // Step 3: Check if the file itself exists. If not, create it.
            if (!Files.exists(path)) {
                Files.createFile(path);
                return; // Nothing to read yet, so we exit the method.
            }

            // Step 4: If the file exists, proceed to read from it using a Scanner.
            System.out.println("Your progress has been saved!");
            Scanner s = new Scanner(path);
            while (s.hasNext()) {
                String input = s.nextLine();
                String[] pieces = input.split(" \\| ");
                if (pieces.length == 3) {
                    Task t = new Todo(pieces[2]);
                    if (Objects.equals(pieces[1], "1")) {
                        t.mark();
                    }
                    ans.add(t);
                } else {
                    if (Objects.equals(pieces[0], "D")) {
                        Task t = new Deadline(pieces[2], LocalDate.parse(pieces[3]));
                        if (Objects.equals(pieces[1], "1")) {
                            t.mark();
                        }
                        ans.add(t);
                    } else {
                        String check = pieces[3];
                        String[] again = check.split("-");
                        Task t = new Event(pieces[2], again[0], again[1]);
                        if (Objects.equals(pieces[1], "1")) {
                            t.mark();
                        }
                        ans.add(t);
                    }
                }
                numOfTasks++;
            }
        } catch (IOException e) {
            System.err.println("lol idk man");
        }

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
            try {
                String input = sc.nextLine().trim();
                String[] line = input.split(" ");
                String command = line[0];
                switch (command) {
                    case "bye":
                        System.out.println(zero);
                        loop = false;
                        break;
                    case "list":
                        System.out.println(zero);
                        System.out.println("    Here are the tasks in your list:");
                        for (int i = 0; i < numOfTasks; i++) {
                            Task curr = ans.get(i);
                            System.out.println("    " + (i + 1) + "." + curr);
                        }
                        System.out.println(zero);
                        break;
                    case "mark":
                        int index = Integer.parseInt(line[1]);
                        Task curr = ans.get(index - 1);
                        curr.mark();
                        System.out.println(zero);
                        System.out.println("    Nice! I've marked this task as done:");
                        System.out.println("      " + curr);
                        System.out.println(zero);
                        helper(ans);
                        break;
                    case "unmark":
                        int index2 = Integer.parseInt(line[1]);
                        Task curr2 = ans.get(index2 - 1);
                        curr2.unmark();
                        System.out.println(zero);
                        System.out.println("    OK, I've marked this task as not done yet:");
                        System.out.println("      " + curr2);
                        System.out.println(zero);
                        helper(ans);
                        break;
                    case "delete":
                        if (numOfTasks == 0) {
                            System.out.println(zero);
                            System.out.println("    There are no current tasks to delete");
                            System.out.println(zero);
                            break;
                        }
                        int index3 = Integer.parseInt(line[1]);
                        if (index3 < 0) {
                            System.out.println(zero);
                            System.out.println("    Input is negative: Pls pick a number from 0 to " + numOfTasks);
                            System.out.println(zero);
                            break;
                        }
                        if (index3 > numOfTasks) {
                            System.out.println(zero);
                            System.out.println("    Max task number you can pick is " + numOfTasks);
                            System.out.println(zero);
                            break;
                        }
                        Task curr9 = ans.get(index3 - 1);
                        ans.remove(index3-1);
                        numOfTasks--;
                        System.out.println(zero);
                        System.out.println("    Noted. I've removed this task:");
                        System.out.println("      " + curr9);
                        System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
                        System.out.println(zero);
                        helper(ans);
                        break;
                    case "todo":
                        if (!input.contains("todo ")) {
                            throw new NumberOfArgumentsException("todo");
                        }
                        String[] arr = input.split("todo ");
                        String info = arr[1];
                        Task curr3 = new Todo(info);
                        //ans[numOfTasks] = curr3;
                        ans.add(curr3);
                        numOfTasks++;
                        System.out.println(zero);
                        System.out.println("    Got it. I've added this task:");
                        System.out.println("      " + curr3);
                        System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
                        System.out.println(zero);
                        helper(ans);
                        break;
                    case "deadline":
                        if (!input.contains("deadline ")) {
                            throw new NumberOfArgumentsException("deadline");
                        }
                        String[] arr2 = input.split("deadline ");
                        String info2 = arr2[1];
                        if (!info2.contains(" /by ")) {
                            throw new NumberOfArgumentsException("deadline");
                        }
                        String[] arr3 = info2.split(" /by ");

                        LocalDate deadline = LocalDate.parse(arr3[1]);
                        Task curr4 = new Deadline(arr3[0], deadline);
                        //ans[numOfTasks] = curr4;
                        ans.add(curr4);
                        numOfTasks++;
                        System.out.println(zero);
                        System.out.println("    Got it. I've added this task:");
                        System.out.println("      " + curr4);
                        System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
                        System.out.println(zero);
                        helper(ans);
                        break;
                    case "event":
                        if (!input.contains("event ")) {
                            throw new NumberOfArgumentsException("event");
                        }
                        String[] arr4 = input.split("event ");
                        String info3 = arr4[1];
                        if (!info3.contains(" /from ")) {
                            throw new NumberOfArgumentsException("event");
                        }
                        String[] arr5 = info3.split(" /from ");
                        String des = arr5[0];
                        String rest = arr5[1];
                        if (!rest.contains(" /to ")) {
                            throw new NumberOfArgumentsException("event");
                        }
                        String[] last = rest.split(" /to ");

                        Task curr5 = new Event(des, last[0], last[1]);
                        //ans[numOfTasks] = curr5;
                        ans.add(curr5);
                        numOfTasks++;
                        System.out.println(zero);
                        System.out.println("    Got it. I've added this task:");
                        System.out.println("      " + curr5);
                        System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
                        System.out.println(zero);
                        helper(ans);
                        break;
                    default:
                        throw new WrongInputException();
                }
            } catch (WrongInputException e) {
                System.out.println(zero);
                System.out.println(e.getMsg());
                System.out.println(zero);
            } catch (NumberOfArgumentsException f) {
                System.out.println(zero);
                System.out.println(f.getMsg());
                System.out.println(zero);
            } catch (DateTimeParseException e) {
                System.out.println(zero);
                System.out.println("Pls input date in format yyyy-mm-dd");
                System.out.println(zero);
            }
        }
        System.out.println(third);
        System.out.println(zero);
    }
}

