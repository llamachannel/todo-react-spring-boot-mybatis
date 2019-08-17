package party.afraidto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDao {
    @Autowired
    TodoItemMapper mapper;

    public int insertItem(TodoItem item) {
        System.out.println("insertItem -- about to call mapper");
        TodoItem newItem = mapper.insertItem(item);
        System.out.println("insertItem, after mapper, newItem = ");
        System.out.println(newItem);
        return newItem.getId();
    }

    public TodoItem getItem(int id) {
        return mapper.getItem(id);
    }

    public List<TodoItem> getItems() {
        return mapper.getItems();
    }
}
