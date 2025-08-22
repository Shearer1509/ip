package sheares;


import sheares.command.*;
import sheares.exception.DukeException;
import sheares.exception.NumberOfArgumentsException;
import sheares.exception.WrongInputException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {
    public static Command parse(String input) throws DukeException, DateTimeParseException {
            String[] line = input.split(" ");
            String command = line[0];
            switch (command) {
                case "bye":
                    return new ExitCommand();

                case "list":
                    return new ListCommand();

                case "mark":
                    int index = Integer.parseInt(line[1]);

                    return new MarkCommand(index - 1);

                case "unmark":
                    int index2 = Integer.parseInt(line[1]);

                    return new UnMarkCommand(index2 - 1);
                    //break;
                case "delete":

                    int index3 = Integer.parseInt(line[1]);

                    return new DeleteCommand(index3 - 1);

                case "todo":
                    if (!input.contains("todo ")) {
                        throw new NumberOfArgumentsException("todo");
                    }
                    String[] arr = input.split("todo ");
                    String info = arr[1];
                    return new AddCommand(info);

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

                    return new AddCommand(arr3[0], deadline);
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
                    return new AddCommand(des, last[0], last[1]);
                default:
                    throw new WrongInputException();
            }
        }
    }
