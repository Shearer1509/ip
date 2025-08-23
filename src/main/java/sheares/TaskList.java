package sheares;
import sheares.task.Task;

import java.util.ArrayList;

/**
 * helper data strcuture to store Tasks for chatbot
 */
public class TaskList {
    private final ArrayList<Task> ls;

    public TaskList(ArrayList<Task> ls) {
        this.ls = ls;
    }

    public int size() {
        return this.ls.size();
    }

    public TaskList() {
        this.ls = new ArrayList<>();
    }

    public void add(Task task) {
        ls.add(task);
    }

    public void delete(int index) {
        ls.remove(index);
    }

    public Task get(int index) {
        return ls.get(index);
    }
}
