package sheares;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import sheares.task.*;
import sheares.exception.*;
public class Storage {

    ArrayList<Task> ans;
    String filePath;
    public Storage(String filePath) {
        this.ans = new ArrayList<>();
        this.filePath = filePath;
    }

    public void save(TaskList ls) {
        try {
            FileWriter fw = new FileWriter("./data/duke.txt");
            for (int i = 0; i < ls.size(); i++) {
                Task task = ls.get(i);
                String output = task.taskToStr();
                fw.write(output + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("file writing off");
        }
    }

    public ArrayList<Task> load() throws DukeException {
        //String filePath = "./data/duke.txt";
        Path path = Paths.get(this.filePath);
        Scanner sc = new Scanner(System.in);

        try {
            Path parentDir = path.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            // Step 3: Check if the file itself exists. If not, create it.
            if (!Files.exists(path)) {
                Files.createFile(path);
                throw new DukeException();
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
            }
        } catch (IOException e) {
            System.err.println("lol idk man");
        }
        return this.ans;
    }

}
