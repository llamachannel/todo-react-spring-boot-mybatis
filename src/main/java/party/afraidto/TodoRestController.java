package party.afraidto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {
    @Autowired
    TodoItemDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoItem> getAllItems() {
        return dao.getItems();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public TodoItem getItem(@PathVariable int id) {
        return dao.getItem(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postItem(@RequestBody TodoItem item) {
        dao.insertItem(item);
    }
}
