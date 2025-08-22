package sheares;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import sheares.command.*;
import sheares.exception.*;
public class Parser {

    public static Command parse(String input) throws DukeException, DateTimeParseException {
            String[] line = input.split(" ");
            String command = line[0];
            switch (command) {
                case "bye":
                    return new ExitCommand();
                    //break;
                case "list":
                    return new ListCommand();
                    //break;
                case "mark":
                    int index = Integer.parseInt(line[1]);
//                    Task curr = ans.get(index - 1);
//                    curr.mark();
//                    System.out.println(zero);
//                    System.out.println("    Nice! I've marked this task as done:");
//                    System.out.println("      " + curr);
//                    System.out.println(zero);
//                    helper(ans);
                    return new MarkCommand(index - 1);
                    //break;
                case "unmark":
                    int index2 = Integer.parseInt(line[1]);
//                    Task curr2 = ans.get(index2 - 1);
//                    curr2.unmark();
//                    System.out.println(zero);
//                    System.out.println("    OK, I've marked this task as not done yet:");
//                    System.out.println("      " + curr2);
//                    System.out.println(zero);
//                    helper(ans);
                    return new UnMarkCommand(index2 - 1);
                    //break;
                case "delete":
//                    if (numOfTasks == 0) {
//                        System.out.println(zero);
//                        System.out.println("    There are no current tasks to delete");
//                        System.out.println(zero);
//                        break;
//                    }
                    int index3 = Integer.parseInt(line[1]);
//                    if (index3 < 0) {
//                        System.out.println(zero);
//                        System.out.println("    Input is negative: Pls pick a number from 0 to " + numOfTasks);
//                        System.out.println(zero);
//                        break;
//                    }
//                    if (index3 > numOfTasks) {
//                        System.out.println(zero);
//                        System.out.println("    Max task number you can pick is " + numOfTasks);
//                        System.out.println(zero);
//                        break;
//                    }
//                    Task curr9 = ans.get(index3 - 1);
//                    ans.remove(index3-1);
//                    numOfTasks--;
//                    System.out.println(zero);
//                    System.out.println("    Noted. I've removed this task:");
//                    System.out.println("      " + curr9);
//                    System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
//                    System.out.println(zero);
//                    helper(ans);
                    return new DeleteCommand(index3 - 1);
                    //break;
                case "todo":
                    if (!input.contains("todo ")) {
                        throw new NumberOfArgumentsException("todo");
                    }
                    String[] arr = input.split("todo ");
                    String info = arr[1];
                    /*Task curr3 = new Todo(info);*/
//                    //ans[numOfTasks] = curr3;
//                    ans.add(curr3);
//                    numOfTasks++;
//                    System.out.println(zero);
//                    System.out.println("    Got it. I've added this task:");
//                    System.out.println("      " + curr3);
//                    System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
//                    System.out.println(zero);
//                    helper(ans);
                    return new AddCommand(info);
                    //break;
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
//                    Task curr4 = new Deadline(arr3[0], deadline);
//                    //ans[numOfTasks] = curr4;
//                    ans.add(curr4);
//                    numOfTasks++;
//                    System.out.println(zero);
//                    System.out.println("    Got it. I've added this task:");
//                    System.out.println("      " + curr4);
//                    System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
//                    System.out.println(zero);
//                    helper(ans);
                    return new AddCommand(arr3[0], deadline);
                    //break;
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

//                    Task curr5 = new Event(des, last[0], last[1]);
//                    //ans[numOfTasks] = curr5;
//                    ans.add(curr5);
//                    numOfTasks++;
//                    System.out.println(zero);
//                    System.out.println("    Got it. I've added this task:");
//                    System.out.println("      " + curr5);
//                    System.out.println("    Now you have " + numOfTasks + " tasks in the list.");
//                    System.out.println(zero);
//                    helper(ans);
                    return new AddCommand(des, last[0], last[1]);
                    //break;
                default:
                    throw new WrongInputException();
            }
        }
    }
