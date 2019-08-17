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
    public String getAllItems() {
        return "TODO";
        //return dao.getItems();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public TodoItem getItemById(@PathVariable int id) {
        System.out.println("handling /{id}, id = " + id);
        return dao.getItemById(id);
    }

    /*
    @RequestMapping(method = RequestMethod.POST)
    public int postItem(@RequestBody TodoItem item) {
        return dao.insertItem(item);
    }
    */
}
