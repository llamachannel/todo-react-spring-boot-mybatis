package party.afraidto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import party.afraidto.domain.TodoItem;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {
    @Autowired
    TodoItemDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoItem> getAllItems() {
        return dao.getItems();
    }

    @RequestMapping(method = RequestMethod.POST)
    public long postItem(@RequestBody TodoItem item) {
        return dao.insertItem(item);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public TodoItem getItemById(@PathVariable int id) {
        return dao.getItemById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean deleteItemById(@PathVariable int id) {
        return dao.deleteItemById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}/complete")
    public boolean postComplete(@PathVariable int id) {
        return dao.completeItem(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}/uncomplete")
    public boolean postUncomplete(@PathVariable int id) {
        return dao.uncompleteItem(id);
    }
}
