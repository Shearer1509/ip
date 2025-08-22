import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> ls;

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
