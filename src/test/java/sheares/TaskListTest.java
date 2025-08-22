package sheares;

import org.junit.jupiter.api.Test;
import sheares.task.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void sizeAndAddTest() {
        TaskList ls = new TaskList();
        ls.add(new Todo("read books"));
        ls.add(new Event("party", "2pm", "6pm"));
        assertEquals(2, ls.size());
    }

    @Test
    public void getTest() {
        TaskList ls = new TaskList();
        ls.add(new Todo("read books"));
        ls.add(new Event("party", "2pm", "6pm"));
        Task retrieve = ls.get(0);
        assertEquals("[T][ ] read books", retrieve.toString());
    }

    @Test
    public void deleteTest() {
        TaskList ls = new TaskList();
        ls.add(new Todo("read books"));
        ls.add(new Event("party", "2pm", "6pm"));
        ls.delete(0);
        Task retrieve = ls.get(0);
        assertEquals("[E][ ] party (from: 2pm to: 6pm)", retrieve.toString());
    }
}
