package party.afraidto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDao {
    @Autowired
    TodoItemMapper mapper;

    public boolean insertItem(TodoItem item) {
        return mapper.insertItem(item) > 0;
    }

    public TodoItem getItem(int id) {
        return mapper.getItem(id);
    }

    public List<TodoItem> getItems() {
        return mapper.getItems();
    }
}
